package com.edu.static_;

public class StaticDetail {

    public static void main(String[] args) {

        //System.out.println(B.n1);  Error

        System.out.println(B.n2);
    }
}

class B {
    public int n1 = 100;
    public static int n2 = 200;
}
