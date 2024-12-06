package com.edu.main_;

public class Main01 {

    private static String name = "alice";
    private double fee = 100;
    public static void main(String[] args) {

        System.out.println(name);//main方法可以访问本类中的静态成员
        //System.out.println(fee);无法访问本类中的普通成员
    }
}
