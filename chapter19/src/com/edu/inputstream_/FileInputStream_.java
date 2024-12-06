package com.edu.inputstream_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//字节输入流   文件-> 程序
public class FileInputStream_ {

    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath = "D:\\.book\\test\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象用于读取文件
             fileInputStream = new FileInputStream(filePath);
            //从该输入流中读取一个字节的数据，如果没有输入可用 此方法将阻止
            //如果返回-1  表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char)readData + "\t");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //使用read(byte[] b) 读取文件  提高效率
    @Test
    public void readFile02() {
        String filePath = "D:\\.book\\test\\hello.txt";
        int readData = 0;
        byte[] buff = new byte[8];// 一次读取8个字节
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流中读取一个字节的数据，如果没有输入可用 此方法将阻止
            //如果返回-1  表示读取完毕
            //如果读取正常  返回实际读取的字节数
            while ((readLen = fileInputStream.read(buff)) != -1) {
                System.out.print(new String(buff, 0, readLen) + "\t");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
