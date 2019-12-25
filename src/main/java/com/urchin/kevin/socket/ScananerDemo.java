package com.urchin.kevin.socket;

import java.util.Scanner;


/**
*@author      :Kevin  Ding
*@Date        :2019年12月17日-下午2:30:23
*@Description :Scanner测试
**/
@SuppressWarnings("all")
public class ScananerDemo {
	private static void scanner() {
		Scanner scanner = new Scanner(System.in);
		String res = "";
		String flag = "测试";
		StringBuilder result = new StringBuilder(res);
		int num = 0;
		res = scanner.nextLine();
		if (res.equalsIgnoreCase("quite")) {
			System.out.println(">>>>>程序结束");
			return;
		}
		if (!"".equals(res)) {
			result.append(res);
		}
		for (int i = 0; i < res.length(); i++) {
			String s = res.substring(i, i+1);
			if (s.equals(flag)) {
				num ++;
			}
		}
		System.out.println(result.toString());
		System.err.println(flag + "出现的次数为" + num);
	}
	public static void main(String[] args) {
		scanner();
	}
}

