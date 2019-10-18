/**
*@author :Kevin  Ding
*@Date :2019年10月12日-下午3:44:54
*@Description :TODO
**/
package com.urchin.kevin;

public class ProAndCost {
	int product = 0;
	public static final int MAX_NUM = 10;
	public static final int MIN_NUM = 1;
	
	public synchronized void produce() {//同步方法
		if (this.product >= MAX_NUM) {
			try {
				System.out.println("产品库存已满,请稍后生产！");
				wait();//进入等待
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return;
		}
		this.product++;
		System.out.println("生产者正在生产第"+product+"个产品");
		notifyAll();//通知等待区的消费者可以取出产品了
	}
	
	public synchronized void consume() {
		if (this.product <= MIN_NUM) {
			try {
				System.out.println("缺货,稍后再取");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return;
		}
		System.out.println("消费者取走了第"+product+"个产品");
		this.product--;
		notifyAll();//通知等待去的生产者可以生产产品了
	}
	
	public static void main(String[] args) {
		ProAndCost p = new ProAndCost();
		ProAndCost c = new ProAndCost();
//		p.product = 20;
		p.produce();
		p.consume();
		c.consume();
		
	}
	

}
