package com.edu.modifier;

import java.sql.SQLOutput;

public class A {

    //四个属性
    public int n1 = 100;
    protected  int n2 = 200;
    int n3 = 300;
    private  int n4 = 400;

    public void m1() {
        //
        System.out.println( n1 +" "+ n2+ " "+ n3+ " " + n4+ " ");
    }
}

