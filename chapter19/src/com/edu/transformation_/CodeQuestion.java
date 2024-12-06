package com.edu.transformation_;

import java.io.BufferedReader;
import java.io.FileReader;

public class CodeQuestion {

    //中文乱码问题
    public static void main(String[] args) throws Exception{
        //读取文件 到程序
        //默认情况下  读取文件格式按照UTF-8
        String filepath = "D:\\.book\\test\\a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filepath));

        String s = br.readLine();
        System.out.println("读取到的内容:" + s);

        br.close();

    }
}
