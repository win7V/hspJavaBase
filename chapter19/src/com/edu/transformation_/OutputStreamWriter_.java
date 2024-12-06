package com.edu.transformation_;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_ {

    public static void main(String[] args) throws Exception{
        //把FileOutputStream 字节流 转成字符流 OutputStreamWriter
        //指定处理的编码 gbk/UTF-8
        String filepath = "D:\\.book\\test\\b.txt";
        String charSet = "UTF-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filepath), charSet);

        osw.write("xixini中文");

        osw.close();
    }
}
