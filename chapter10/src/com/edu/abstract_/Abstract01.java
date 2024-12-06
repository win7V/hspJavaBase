package com.edu.abstract_;

public class Abstract01 {

    public static void main(String[] args) {

    }
}


abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //父类方法不确定性问题
    /*
    public void eat() {
        System.out.println("unknown");
    }

     */
    //将该方法设计为抽象方法
    //当一个类中存在抽象方法  需要将该类声明为abstract类
    //抽象方法不能有方法体
    public abstract void eat();
}