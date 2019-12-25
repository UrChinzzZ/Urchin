/**
*@author :Kevin  Ding
*@Date :2019年10月11日-下午1:55:32
*@Description :TODO
**/
package com.urchin.kevin;

public class Seven {
	public static void main(String[] args) {
		int x ,p,i,s=0;
		for(x = 1; x<6;x++) {
			for(p = i = 1;i <= x;i++) {
				p *= x;
			}
			s += p;
		}
		System.out.println("P"+s);
	}
}
