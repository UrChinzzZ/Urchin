/**
*@author :Kevin  Ding
*@Date :2019年7月11日-下午5:11:18
*@Description :lambdaTest
**/

package com.urchin.Algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lambda {
	static void threadNoUseLambda() {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("no use lambda");
			}
		});
		thread1.start();
	}
	static	void threadUseLambda() {
		Thread thread2 = new Thread(() -> System.err.println("use lambda"));
		thread2.start();
	}


	static void operateNumber(int type) {
		List<Integer> integers = Arrays.asList(4, 5, 6,1, 2, 3,7, 8,8,9,10);
		if (type == 0) {
			Thread thread3 = new Thread(() -> {
				List<Integer> evens = integers.stream().filter(i -> i % 2 == 0)
			        .collect(Collectors.toList());
					System.out.println(evens);
				})  ;
			thread3.start();
		}else {
			Thread thread4 = new Thread(() ->{
				List<Integer> odds = integers.stream().filter(i -> i % 2 != 0)
				        .collect(Collectors.toList());
						System.out.println(odds);
					});
			thread4.start();
		}
	}
	public static void main(String[] args) {
		threadNoUseLambda();
		threadUseLambda();
		Random random = new Random();
		int type = random.nextInt(2);
		operateNumber(type);
	}
}
