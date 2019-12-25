package com.urchin.kevin.exception;
/**
*@author      :Kevin  Ding
*@Date        :2019年12月18日-下午2:43:18
*@Description :TODO
**/
public class ArrayIndex {
	private static void setArray(int [] array) throws ArrayIndexException{
		for (int i = 0; i < (array.length + 1); i++) {
			array[i] = 5;
		}
	}
	public static void main(String[] args) {
		int array [] = new int[3];//用于测试越界的数组
		try {
			setArray(array);
		} catch (ArrayIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("go on !");
		for (int j = 0; j < array.length; j++) {
			System.out.print(array[j] + "\t");//再越界之前的数成功赋值
		}
	}
}

