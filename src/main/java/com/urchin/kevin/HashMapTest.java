/**
*@author :Kevin  Ding
*@Date :2019年8月20日-上午9:48:09
*@Description :TODO
**/
package com.urchin.kevin;

public class HashMapTest {
	public static void main(String[] args) {
		int res =  tableSizeFor(17);
		System.out.println(res);
		int [] array = {1,2,3,4,5};
	 	int idx = index(array, 4);
	 	System.out.println("所查询的值的下标为"+idx);
	}
	
	/** 
	 * @param cap
	 * @return
	 */
	static int tableSizeFor(int cap) {
		int n = cap - 1;
		n|= n>>>1;//向右移位3
		n|= n>>>2;
		n|= n>>>4;
		return (n<0)?1:n+1;
		
	}
	
	/**
	 * 二分法查找
	 * @param array 需要进行检索的数组
	 * @param idx 需要检索的值
	 * @return 该值的下标或-1:未找到
	 */
	static int index(int[] array,int idx) {
		int min = 0;
		int max = array.length - 1;
		while(min < max) {
			int middle = (min + max)/2;
			if (array[middle] == idx) {
				return middle;
			}
			
			if (idx > array[middle]) {
				min = middle + 1;
			}else {
				max = middle - 1;				
			}
		}
		return -1;
	}
}
