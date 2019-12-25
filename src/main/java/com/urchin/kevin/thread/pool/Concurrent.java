/**
*@author :Kevin  Ding
*@Date :2019年10月21日-下午2:06:30
*@Description :线程池并发
**/
package com.urchin.kevin.thread.pool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
@SuppressWarnings("unchecked")
public class Concurrent {
	static class MyCallable implements Callable<Object>{//内部类  修饰符用static
		private String taskNums;
		
		

		/**
		 * @param taskNums 任务数量
		 */
		public MyCallable(String taskNums) {
//			super();
			this.taskNums = taskNums;
		}



		/* (non-Javadoc)
		 * @see java.util.concurrent.Callable#call()
		 */
		@Override
		public Object call() throws Exception {
			// TODO Auto-generated method stub
			System.out.println(">>>任务启动" +taskNums);
			Date dateTemp1 = new Date();
			Thread.sleep(1000);
			Date dateTemp2 = new Date();
			long time = dateTemp2.getTime() - dateTemp1.getTime();
			System.out.println(">>>任务结束" + taskNums);
			return taskNums + "任务返回运行结果，当前任务时间为【"+time+"毫秒】";
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("--- 程序开始运行 ---");
		Date date1 = new Date();
		int taskSize = 5;
		//创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		//创建多个有返回值的任务
		List<Future> list = new ArrayList<>();
		for (int i = 0; i < taskSize; i++) {
			Callable c = new MyCallable(i+"");
			// 执行任务并获取Future对象
			Future f = pool.submit(c);
			list.add(f);
		}
		pool.shutdown();
		for (Future future : list) {
			System.out.println(future.get().toString());
		}
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime();
		System.out.println("--- 程序运行结束 ---,程序运行时间为【"+time+"毫秒】");
	}

}
