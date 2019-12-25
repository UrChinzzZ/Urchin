/**
*@author :Kevin  Ding
*@Date :2019年10月14日-下午3:21:15
*@Description :线程响应中断
**/
package com.urchin.kevin.thread.comm.demo4;

import java.util.concurrent.TimeUnit;

public class StopThread extends Thread{
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().getName()+"运行中..####");
		}
		System.out.println(Thread.currentThread().getName()+"退出..####");
	}
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new StopThread(),"thread A");
		thread.start();
		System.out.println("#####main 线程正在运行！####");
		
		TimeUnit.MILLISECONDS.sleep(10);
		Thread.interrupted();
	}

}
