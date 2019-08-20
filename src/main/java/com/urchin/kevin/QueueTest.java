/**
*@author :Kevin  Ding
*@Date :2019年8月15日-下午3:40:31
*@Description :队列测试
**/
package com.urchin.kevin;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		
		queue.add("1");
		queue.add("3");
		queue.add("2");
		if (queue.contains("3")) {
			
			queue.remove("3");//根据键值删除
		}
		
		for (String string : queue) {
			System.out.println(string);
		}
	}

}
