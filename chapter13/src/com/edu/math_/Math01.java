package com.edu.math_;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Math01 {

    public static void main(String[] args) {
//        int a;
//        int b;
//        System.out.println("input a and b:");
//        Scanner scanner = new Scanner(System.in);
//
//        a = scanner.nextInt();
//        b = scanner.nextInt();
//
//        for (int i = 0; i < 1000; i++) {
//            //int c = a + (int)(Math.random() * (b - a + 1));//a-b间随机整数
//            double randomNum = a + (Math.random() * (b - a));
//            System.out.println(randomNum);
//        }

        int arr[] = {1,-1,5,50};

        bubble01(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(System.currentTimeMillis());

        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(date);
        System.out.println(format);
    }

    public static void bubble01(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}

