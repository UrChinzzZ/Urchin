package com.urchin.DesignPatterns.FactoryModel.SimpleFactory;
import com.urchin.DesignPatterns.FactoryModel.SimpleFactory.FactoryCategory.algorithm.algorithm;
import com.urchin.DesignPatterns.FactoryModel.SimpleFactory.FactoryCategory.algorithm.algorithmImpl.algorithm_impl;
import java.util.Scanner;

public class Test {
    //测试类
   public static void main(String[] args) {
        /*algorithm algorithm=new algorithm_impl();
        Scanner scanner=new Scanner(System.in);
        Scanner scanner3=new Scanner(System.in);
        System.out.println("选择计算方法 1：加法，2:乘法，3：减法，4：除法");
        int all=scanner3.nextInt();
        if (all==1){
            System.out.println("请输入第一个数");
            int a=scanner.nextInt();
            Scanner scanner1=new Scanner(System.in);
            System.out.println("请输入第二个数");
            int b=scanner1.nextInt();
            System.out.println("结果是："+ algorithm.addition(a,b));
        }else if (all==2){
            System.out.println("请输入第一个数");
            int a=scanner.nextInt();
            Scanner scanner1=new Scanner(System.in);
            System.out.println("请输入第二个数");
            int b=scanner1.nextInt();
            algorithm.multiplication(a,b);
            System.out.println("结果是："+algorithm.multiplication(a,b));
        }else if (all==3){
            System.out.println("请输入第一个数");
            int a=scanner.nextInt();
            Scanner scanner1=new Scanner(System.in);
            System.out.println("请输入第二个数");
            int b=scanner1.nextInt();
            algorithm.subtraction(a,b);
            System.out.println("结果是："+ algorithm.subtraction(a,b));
        }else {
            System.out.println("请输入第一个数");
            int a=scanner.nextInt();
            Scanner scanner1=new Scanner(System.in);
            System.out.println("请输入第二个数");
            int b=scanner1.nextInt();
            System.out.println("结果是："+algorithm.division(a,b));
        }
*/
	   	calculate();
    }
	//给sb书豪的代码优化
    public static void  calculate() {
    	algorithm algorithm=new algorithm_impl();
        Scanner scanner=new Scanner(System.in);
        Scanner scanner3=new Scanner(System.in);
        System.out.println("请输入第一个数");
        int a=scanner.nextInt();
        Scanner scanner1=new Scanner(System.in);
        System.out.println("请输入第二个数");
        int b=scanner1.nextInt();
        System.out.println("选择计算方法 1：加法，2:乘法，3：减法，4：除法");
        int all=scanner3.nextInt();
        switch(all) {
        	case 1:
                System.out.println("结果是："+ algorithm.addition(a,b));
                break;
        	case 2:
        		 System.out.println("结果是："+algorithm.multiplication(a,b));
        		 break;
        	case 3:
        		 System.out.println("结果是："+ algorithm.subtraction(a,b));
        		 break;
        	case 4:
        		 System.out.println("结果是："+algorithm.division(a,b));
        		 break;	
        }    
    }


}
