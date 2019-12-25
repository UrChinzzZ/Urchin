/**
*@author :Kevin  Ding
*@Date :2019年10月14日-下午2:06:51
*@Description :Join的含义是：将某一线程加入成为另一个线程的流程之一，换言之就是等待另一个线程执行完毕。
**/
package com.urchin.kevin.thread.comm.demo2;

public class FunJoin {
	private static void join() throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("RUNNING1");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("RUNNING2!");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		thread1.start();
		thread2.start();
        //等待线程1终止
		thread1.join();
        //等待线程2终止
		thread2.join();
		//线程1 2 终止后 执行打印语句
		System.err.println("main over");//主线程执行的语句
		
	}
	/*在 t1.join() 时会一直阻塞到 t1 执行完毕，所以最终主线程会等待 t1 和 t2 线程执行完毕。
	其实从源码可以看出，join() 也是利用的等待通知机制：*/
	public static void main(String[] args) throws InterruptedException {
		join();
	}
}
