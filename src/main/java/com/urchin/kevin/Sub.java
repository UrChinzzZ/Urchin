/**
*@author :Kevin  Ding
*@Date :2019年10月11日-下午1:44:51
*@Description :TODO
**/
package com.urchin.kevin;

public class Sub extends DongCheng{
	private String baseName = "sub";
	private static String testName = "testName";
	
	public void callName() {
		System.out.println(baseName);
	}
	
	public static void main(String[] args) {
		DongCheng base = new Sub();
		//do while 循环
		int i = 0 ;
//		do {
//			System.out.println(i);
//			i++;
//		} while (i <= 5);
		
		//while
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
	}
}
