package com.edu.wrapper;

public class Integer01 {

    public static void main(String[] args) {

        //jdk5以后自动装箱和自动拆箱
        int n1 = 200;
        Integer integer1 = n1;//底层使用的是 Integer.valueof(n1)

        int n2 = integer1;//底层使用的是 intValue()

    }
}
