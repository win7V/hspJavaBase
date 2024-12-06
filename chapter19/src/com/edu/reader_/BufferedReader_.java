package com.edu.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_ {

    public static void main(String[] args) throws  Exception{


        String filepath = "D:\\.book\\test\\story.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader((filepath)));
        //d读取
        String line; //按行读取 效率较高
        //当返回为空时 文件读取完毕
        while ( (line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流  只需要关闭外层即可
        bufferedReader.close();
    }
}
