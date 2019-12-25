/**
*@author :Kevin  Ding
*@Date :2019年10月14日-上午11:59:53
*@Description :偶数线程
**/
package com.urchin.kevin.thread.comm.demo1;

public class OuNum implements Runnable{
	
	private TwoThreadWaitNotify number;
	
	
	/**
	 * @param number
	 */
	public OuNum(TwoThreadWaitNotify number) {
//		super();
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (number.start <= 100) {
			synchronized (TwoThreadWaitNotify.class) {
				System.out.println("偶数线程抢到了锁");
				if (number.flag) {
                    System.out.println(Thread.currentThread().getName() + "+-+偶数" + number.start);
                    number.start++;
                    number.flag = false;
                    TwoThreadWaitNotify.class.notify();
				}else {
					 try {
                         TwoThreadWaitNotify.class.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
				}
			}
		}
	}

}
