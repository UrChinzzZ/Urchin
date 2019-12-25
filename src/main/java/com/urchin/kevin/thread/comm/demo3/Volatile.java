/**
*@author :Kevin  Ding
*@Date :2019年10月14日-下午3:04:40
*@Description :TODO
**/
package com.urchin.kevin.thread.comm.demo3;

import java.util.concurrent.TimeUnit;

public class Volatile implements Runnable{
	private static volatile boolean flag = true;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			System.out.println(Thread.currentThread().getName()+"正在运行!");
		}
		System.out.println(Thread.currentThread().getName()+"执行完毕！");
	}
	private void stopThread(){
        flag = false ;
    }
	
	public static void main(String[] args) throws InterruptedException {
		Volatile  volatile1 = new Volatile();
		new Thread(volatile1,"Thread A").start();
		
		System.out.println("main 线程 正在运行");
		
		TimeUnit.MILLISECONDS.sleep(100);
		volatile1.stopThread();
	}

}
