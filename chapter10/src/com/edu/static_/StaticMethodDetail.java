package com.edu.static_;

public class StaticMethodDetail {

    public static void main(String[] args) {


    }
}

class C {
    private int n1 = 100;
    private static int n2 = 200;
    public void say() {

    }

    public static void hi() {
        //类方法中不允许使用和对象有关的关键字
        //比如this,super 普通方法可以

        //System.out.println(this.n1);  Error
    }

    //静态方法中  只能访问 静态变量 或者 静态方法
    public static void hello() {

        //System.out.println(n1); Error
        System.out.println(n2);


    }
}