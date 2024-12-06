package com.edu.Dynamic;

//属性哪里定义用哪里  方法哪里调用用哪里
public class DynamicBinding {
    public static void main(String[] args) {
        A1 a = new B1(); // 向上转型
        System.out.println(a.sum());  // 输出多少？
        System.out.println(a.sum1()); // 输出多少？

    }
}

class A1 {
    public int i = 10;
    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B1 extends A1 {
    public int i = 20;
//    public int sum() {
//        return i + 20;
//    }

    public int getI() {
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}


