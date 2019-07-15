/**
*@author :Kevin  Ding
*@Date :2019年7月15日-下午2:45:35
*@Description :二叉树实现快速排序
**/
package com.urchin.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public Node leftNode;
  
    public Node rightNode;
  
   
    public Object value;
  
    public void add(Object v) {
       
        if (null == value)
            value = v;
        else {
            if ((Integer) v -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);
            }
        else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }
  
        }
  
    }
    
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
        if (null != leftNode)
            values.addAll(leftNode.values());
        values.add(value);
        if (null != rightNode)  
            values.addAll(rightNode.values());  
        return values;
    }
 
    
    public static void main(String[] args) {
    	  
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
  
        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }
        System.out.println("数据插入二叉树并排序完成，接下来完成遍历输出：");
        System.out.println(roots.values());
    }

}
