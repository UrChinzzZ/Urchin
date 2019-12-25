/**
*@author :Kevin  Ding
*@Date :2019年10月14日-下午12:04:17
*@Description :TODO
**/
package com.urchin.kevin.thread.comm.demo1;

public class JiNum implements Runnable {
    private TwoThreadWaitNotify number;
    
	/**
	 * @param number
	 */
	public JiNum(TwoThreadWaitNotify number) {
		super();
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
                 System.out.println("奇数线程抢到锁了");
                 if (!number.flag) {
                     System.out.println(Thread.currentThread().getName() + "+-+奇数" + number.start);
                     number.start++;

                     number.flag = true;
                     
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
