/**
*@author :Kevin  Ding
*@Date :2019年8月20日-上午10:16:25
*@Description :忽略安全策略问题
**/
package com.urchin.kevin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@SuppressWarnings("all")
public class ProAndCosTest {
	public static void main(String[] args) {//由mian进入主线程
	 List pros = new ArrayList<>();
	 Object lock = "lock"; //对象锁
	 Thread pro = new Thread(new Runnable() {
		
		@Override
		public void run() {
			synchronized (lock) {
				
				// TODO Auto-generated method stub
				Random random = new Random();
				int product = random.nextInt(5);
				System.out.println("生产者生产的产品为" + product);
				pros.add(product);
				System.out.println(pros.size());
				
			}
		}
	});
	 pro.setPriority(9);//设置优先级，让生产者先生产
	 pro.start();
	 
	 Thread cos = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (lock) {
				
				if (pros.size() > 0) {
					for (Object pro : pros) {
						System.out.println("消费者消费的产品为 " + pro);
					}
				}else {
					try {
						Thread.sleep(2000);
						System.out.println("生产者无产品产出，消费者等待中");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	});
	cos.start();
		
	
	
	}
}
