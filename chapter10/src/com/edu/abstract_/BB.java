package com.edu.abstract_;

public class BB extends Template{

    public void job() {
        System.out.println("实现BB的job");

        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum *= i;
        }
    }
}
