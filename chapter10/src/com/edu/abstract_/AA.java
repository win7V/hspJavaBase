package com.edu.abstract_;

public class AA extends Template {

    public void job() {
        System.out.println("实现AA的job");
        int sum = 0;
        for (int i = 0; i < 5000000; i++) {
            sum += i;
        }
    }
}
