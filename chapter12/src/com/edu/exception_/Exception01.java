package com.edu.exception_;

public class Exception01 {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;


        try {
            int res = num1 / num2;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());// 输出异常信息
        }

        System.out.println("程序继续运行");
    }
}
