package com.edu;

public class CpuNum {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的cpu数目
        int cpuNums = runtime.availableProcessors();
        System.out.println(cpuNums);


    }
}
