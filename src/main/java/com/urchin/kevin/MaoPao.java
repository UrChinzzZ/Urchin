/**
*@author :Kevin  Ding
*@Date :2019年10月11日-下午2:03:10
*@Description :TODO
**/
package com.urchin.kevin;

import java.util.Arrays;

public class MaoPao {
	
	public static void main(String[] args) {
		 //冒泡排序算法
        int[] numbers=new int[]{3,1,2,6,7,8,9,5,4};
        int i,j;
        for(i=0;i<numbers.length;i++)//冒泡次数(遍历数组元素)
        {
            for(j=0;j<numbers.length-1-i;j++)
            {
            	//如果顺序不对，则交换两个元素，大的在前，小的在后
                if(numbers[j]<numbers[j+1]) 
                {
                    int temp=numbers[j]; //临时变量用于交换元素位置
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        
//        Arrays.sort(numbers); //快速排序  从小到大
        System.out.println("排序后的结果是:");
        for(i=0;i<numbers.length;i++)
        	System.out.print(numbers[i]+" ");
    }
	
	
	
	
}
