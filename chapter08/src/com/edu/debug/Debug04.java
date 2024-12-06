package com.edu.debug;

import java.util.Arrays;

public class Debug04 {

    public static void main(String[] args) {

        int[] arr = {1, -1, 10, 1000};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(100);
        System.out.println(200);
        System.out.println(300);
        System.out.println(400);
    }
}
