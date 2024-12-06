package com.edu.transformation_;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class InputStreamReader_ {

    public static void main(String[] args) throws Exception{
        //转换流解决中文乱码问题
        //将字节流FileInputStream 转换成字符流FileInputStreamReader
        String filepath = "D:\\.book\\test\\a.txt";
        //把 FileInputStream 转成了InputStreamReader  指定编码UTF-8
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath), "UTF-8");
        //把InputStreamReader 传给 BufferedReader
        BufferedReader br = new BufferedReader(isr);

        //读取
        String s = br.readLine();

        System.out.println("读取到的内容：" + s);

        br.close();
    }
}
