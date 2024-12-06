package com.edu.try_;

public class TryCatchDetail {

    public static void main(String[] args) {
        try {
            String str = "hhh";
            int a = Integer.parseInt(str);
            System.out.println("num is " + a);
        } catch (NumberFormatException e) {
            System.out.println("异常信息:" + e.getMessage());
        } finally {
            System.out.println("finally execute");
        }

        System.out.println("Continue to execute");




    }
}
