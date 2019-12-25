/**
*@author :Kevin  Ding
*@Date :2019年10月21日-下午3:45:58
*@Description :TODO
**/
package com.urchin.kevin.thread.pool.model;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
	static ConnectionPool pool = new ConnectionPool(10);
	//保证所有的ConnectionRunner同时开始
	static CountDownLatch start = new CountDownLatch(1);
	//保证main线程等到所有ConnectionRunner结束后才能继续执行
	static CountDownLatch end;
	//一个不断尝试从连接池获取连接的任务
	static class ConnectionRunner implements Runnable{
		int count;//每条线程尝试获取次数
		AtomicInteger got; //所有线程获取到的总数
		AtomicInteger notgot;//所有线程没获取 到的总数
		


		/**
		 * @param count
		 * @param got
		 * @param notgot
		 */
		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notgot) {
			super();
			this.count = count;
			this.got = got;
			this.notgot = notgot;
		}



		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				start.await();//等待start.countDown()的执行
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			while (count-- > 0 ) {
				try {
					Connection connection = pool.fetchConnection(1000);
					if (connection == null) {
						notgot.incrementAndGet();
					}else {
						try {
							connection.createStatement();
							connection.commit();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}finally {
							pool.relaseConnection(connection);
							got.incrementAndGet();
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			end.countDown();
		}
		
	}
	//主方法执行，调度不成功，程序存在问题
	public static void main(String[] args) throws Exception {
		//线程数量
		int threadCount = 30;
		end = new CountDownLatch(threadCount);
		
		int count = 20;
		AtomicInteger got=new AtomicInteger();
		AtomicInteger notgot=new AtomicInteger();
		
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new ConnectionRunner(count, got, notgot),"ConnectionRunnerThread"+i);
			thread.start();
		}
		start.countDown();//发送启动命令
		end.await();//等待所有ConnectionRunner线程结束
		System.out.println("total invoke:"+(threadCount*count));
		System.out.println("got connection:"+got.get());
		System.out.println("not got connection:"+notgot.get());

	}

}
