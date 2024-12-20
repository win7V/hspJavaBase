package com.edu.interface_;

public interface AInterface {

    //写属性  方法

    public int n1 = 10;
    //接口中  抽象方法  可以省略 abstract
    public void hi();

    //在jdk8后 可以有默认实现方法  需要使用default关键字修饰
    default public void ok() {
        System.out.println("AInterface ok");
    }

    //在jdk8后， 可以有静态方法
    public static void cry() {
        System.out.println("AInterface cry");
    }

}
