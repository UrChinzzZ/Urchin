/**
*@author :Kevin  Ding
*@Date :2019年10月14日-下午4:37:10
*@Description :线程池 awaitTermination() 方法 :如果是用线程池来管理线程，可以使用以下方式来让主线程等待线程池中所有任务执行完毕:
**/
package com.urchin.kevin.thread.comm.demo5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	private static void executorService() throws Exception {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MILLISECONDS, queue);
		poolExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("####running####");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		
		poolExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("####running2####");
			}
		});
		
		poolExecutor.shutdown();
		while (!poolExecutor.awaitTermination(1,TimeUnit.SECONDS)){
			System.out.println("###线程还在执行中###");
		}
		System.out.println("###main over###");
	}
	
	public static void main(String[] args) throws Exception {
		executorService();
	}
}
