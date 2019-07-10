package com.urchin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class algorithmTest {

    public static void  start(){
        int[] array={5,1,2,9,15,16,151,11,0};
        int runcount=0;
        int allcount=0;
        int max=0;
        for (int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    max=array[j];
                    array[j]=array[j+1];
                    array[j+1]=max;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
         start();
    }
}
