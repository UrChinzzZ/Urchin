/**
*@author :Kevin  Ding
*@Date :2019年10月14日-上午11:53:16
*@Description :两个线程通过对同一对象调用等待 wait() 和通知 notify() 方法来进行通讯。
			 eg:两个线程交替打印奇偶数：
**/
package com.urchin.kevin.thread.comm.demo1;

public class TwoThreadWaitNotify {
    public  int start = 1; 
    public boolean flag = false;
    
    public static void main(String[] args) {
    	TwoThreadWaitNotify twoThread = new TwoThreadWaitNotify();

        Thread t1 = new Thread(new OuNum(twoThread));
        t1.setName("A");


        Thread t2 = new Thread(new JiNum(twoThread));
        t2.setName("B");

        t1.start();
        t2.start();
       /* 这里的线程 A 和线程 B 都对同一个对象 TwoThreadWaitNotify.class 获取锁，A 线程调用了同步对象的 wait() 方法释放了锁并进入 WAITING 状态。

          B 线程调用了 notify() 方法，这样 A 线程收到通知之后就可以从 wait() 方法中返回。

                 这里利用了 TwoThreadWaitNotify.class 对象完成了通信。*/
	}
}
