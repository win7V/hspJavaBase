package com.edu.wrapper;

public class WrapperVSString {

    public static void main(String[] args) {
        //Integer -> String
        Integer i = 100;
        String str1 = i + "";

        String str2 = i.toString();

        String str3 = String.valueOf(i);

        //String->Integer

        String str4 = "123";
        int i2 = Integer.parseInt(str4);//使用到自动装箱

        Integer i3 = new Integer(str4);

        //FFTFFTT
        // 只要有基本数据类型 == 值 就是判断值是否相等
    }
}
