package com.urchin.kevin.concurrent;
/**
*@author      :Kevin  Ding
*@Date        :2019年12月19日-下午2:15:36
*@Description :一个继承，倆实现
**/
public class SynchronizedTest implements Runnable{
	static int i = 0;
	
	public synchronized void increase() {
		i++;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int j = 0; j < 10; j++) {
			increase();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		SynchronizedTest test = new SynchronizedTest();
		Thread thread = new Thread(test);
		Thread thread2 = new Thread(test);
		thread.start();
		thread2.start();
		thread.join();//线程从并行变成串行，目的让主方法 等待县城执行完毕
		thread2.join();
		System.out.println(i);
	}
	
	
}

