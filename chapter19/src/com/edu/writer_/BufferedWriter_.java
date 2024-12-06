package com.edu.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriter_ {

    public static void main(String[] args) throws Exception{

        String filepath = "D:\\.book\\test\\a.txt";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));

        bufferedWriter.write("hhhhhh");
        bufferedWriter.newLine();//插入一个换行
        bufferedWriter.write("aaaaa");

        bufferedWriter.close();
    }
}
