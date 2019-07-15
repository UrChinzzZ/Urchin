package com.urchin.DesignPatterns.FactoryModel.SimpleFactory.FactoryCategory.algorithm.algorithmImpl;
import com.urchin.DesignPatterns.FactoryModel.SimpleFactory.FactoryCategory.algorithm.algorithm;
import java.math.BigDecimal;
public class algorithm_impl implements algorithm{

    @Override

    public int addition(int a,int b) {
        return a+b;
    }

    @Override
    public BigDecimal  division(int a,int b) {
        BigDecimal decimal=new   BigDecimal(a);
        BigDecimal decimal2=new  BigDecimal(b);
        BigDecimal result=decimal.divide(decimal2,20,BigDecimal.ROUND_HALF_UP);
        return  result;
    }

    @Override
    public int  multiplication(int a,int b) {
        return  a*b;
    }

    @Override
    public int subtraction(int a,int b) {
        return a-b;
    }
}

