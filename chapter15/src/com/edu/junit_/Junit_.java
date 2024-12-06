package com.edu.junit_;

import org.junit.jupiter.api.Test;

public class Junit_ {

    public static void main(String[] args) {

        new Junit_().m1();
        new Junit_().m2();


    }


    @Test
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }
}


