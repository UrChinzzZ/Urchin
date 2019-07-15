package com.urchin.Algorithm;

import java.util.Arrays;
public class algorithmTest {
    static  int  total_Length=0;//总长度
    static  int  determine_Length=0;//确定长度
    public static void main(String[] args) {
        int  total_Length=0;//总长度
        int  determine_Length=0;//确定长度
        start();
        start2();
    }
    public static void  start(){
        long startTime=System.nanoTime(); //获取开始时间
        int[] array={5,1,2,9,15,16,151,11,0};
        int max=0;
        for (int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    max=array[j];
                    array[j]=array[j+1];
                    array[j+1]=max;
                }
                determine_Length+=1;
            }
                total_Length+=1;
        }
        System.out.println("总运行数="+total_Length);
        System.out.println("内部运行数="+determine_Length);
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
        long endTime = System.nanoTime();
        System.out.println("+=用时："+(endTime - startTime)+"纳秒");
    }
    /*如果想上面一样的排序  会有很多的无用的循环和遍历量   当一个数被确定好以后 他就不需要再进行放入数组循环 ，即数组不确定数减少一，数组长度
       要减少一个数组的长度
       方案   定义一个总长度  再定义一个已经确定数长度   总长度—确定数长度=下次需要的循环数  效率就就会变高
    * */
    private static void start2() {
        long starTime = System.nanoTime();
        int[] array={5,1,2,9,15,16,151,11,0};
        int max=0;
        for (int  i=0;i<array.length;i++){
            for (int j=0;j<array.length-1;j++){
                if (array[j]>array[j+1]){
                    max=array[j];
                    array[j]=array[j+1];
                    array[j+1]=max;
                    determine_Length+=1;
                }
                total_Length+=1;
            }
        }
        System.out.println("总运行数="+total_Length);
        System.out.println("内部运行数="+determine_Length);
        System.out.println(Arrays.toString(array));
        long endTime = System.nanoTime();
        System.out.println(array.length);
        System.out.println("+=用时："+(endTime - starTime)+"纳秒");
    }
}


