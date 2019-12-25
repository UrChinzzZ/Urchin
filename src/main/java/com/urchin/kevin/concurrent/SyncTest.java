package com.urchin.kevin.concurrent;

import java.util.HashMap;
import java.util.Map;

/**
*@author      :Kevin  Ding
*@Date        :2019年12月19日-下午2:40:23
*@Description :一个线程获取了该对象的锁之后，其他线程来访问其他synchronized实例方法现象
**/
public class SyncTest {
	public synchronized void method1() {
		System.out.println("method1 start");
		
		try {
			System.out.println("method1 execute");
			Thread.sleep(1000 * 3);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("method1 end");
	}
	
	public  void method2() {
		System.err.println("method2 start");;
		
		try {
			System.err.println("method2 execute");
			Thread.sleep(1000 * 3);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.err.println("method2 end");
	}
	
	public static void main(String[] args) {
		final SyncTest test = new SyncTest();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				test.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				test.method2();
			}
		}).start();
		String s = "126856264";
		int a = Integer.parseInt(s);
		Map<String, String> map = new HashMap<>();
		map.put("shop_id", s);
	}
	//结果分析：可以看出其他线程来访问synchronized修饰的其他方法时需要等待线程1先把锁释放
}

