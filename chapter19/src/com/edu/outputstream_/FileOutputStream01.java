package com.edu.outputstream_;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream01 {

    public static void main(String[] args) {

    }

    //将数据写入文件
    //如果该文件不存在 就创建该文件
    @Test
    public  void  writeFile() {
        String filepath = "D:\\.book\\test\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //得到一个 FileOutputStream对象
            fileOutputStream = new FileOutputStream(filepath); //当写入的内容 会覆盖原来的内容
            //写入一个字节
            fileOutputStream.write('H');
            //写入字符串
            String str = "elloworld";
            fileOutputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


