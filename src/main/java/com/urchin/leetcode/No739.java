package com.urchin.leetcode;

/**
 * @ClassName No739
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/9/18 0018
 * @Version V1.0
 **/

public class No739 {
    /*
    根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
    * */
    public static void main(String[] args) {
        for (int i = 0; i <first().length ; i++) {
            System.out.println(first()[i]);
        }
    }
    /*
    *  最简单的方法  就是依次遍历  当遇到比当前比较值大的时候记录并退出内层循环
    *   时间复杂度最坏情况 o(n^2)
    * */
    public  static int[] first(){
        int[] temperatures={73,74,75,71,69,72,76,73};
        int[] result=new  int[temperatures.length];
        for (int i=0;i<temperatures.length;i++){
            int current=temperatures[i];
            if (current<100){
                for (int j=i+1;j<temperatures.length;j++){
                    if (temperatures[j]>current){
                        result[i]=j-i;
                        break;
                    }
                }
            }
        }
        return result;
    }
    /*
    *   但是这种方法虽然简单  但是也耗费了大量的时间  我们应该减少不必要的遍历次数
    * */
    public  static  int[] two(){
        int[] temperatures={73,74,75,71,69,72,76,73};
        int[] result=new  int[temperatures.length];
        
        return  result;
    }

}
