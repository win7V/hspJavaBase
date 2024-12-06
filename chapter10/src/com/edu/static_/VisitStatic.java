package com.edu.static_;

public class VisitStatic {

    public static void main(String[] args) {

        System.out.println(A.name);//类名.类变量名 访问   即使没有创建对象实例 也可以访问

        A a = new A();
        System.out.println(a.name);//对象名.类变量名

    }
}

class A {
    public static String name = "bob";
}
