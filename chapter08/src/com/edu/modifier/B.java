package com.edu.modifier;



public class B {
    public void say() {
        A a = new A();
        //同一个pack下 可以访问 public protected 默认 不能访问private
        System.out.println( a.n1 +" "+ a.n2+ " "+ a.n3+ " " );
    }
}
