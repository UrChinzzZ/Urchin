/**
*@author :Kevin  Ding
*@Date :2019年9月20日-下午1:50:25
*@Description :泛型类测试
**/
package com.urchin.kevin;

public class GenericsTest<T> {
	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get () {
		return t;	
	}
	
	public static void main(String[] args) {
		GenericsTest<String> strType = new GenericsTest<>();
		strType.add(new String("指定泛型类参数为字符"));
		
		GenericsTest<Integer> intType = new GenericsTest<>();
		intType.add(new Integer(10));//指定泛型类参数为int
		
		System.out.println(strType.get());
		System.err.println(intType.get());
	}

}
