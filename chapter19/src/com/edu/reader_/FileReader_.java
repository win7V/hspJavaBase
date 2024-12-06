package com.edu.reader_;


import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {

    public static void main(String[] args) {



    }

    //单个字符读取文件
    @Test
    public void readFile01() {
        String filepath = "D:\\.book\\test\\story.txt";
        FileReader fileReader = null;
        int data = 0;

        try {
            fileReader = new FileReader(filepath);
            //循环读取
            //使用read
            while ((data = fileReader.read()) != -1) {
                System.out.print((char)data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //使用字符数组读取文件
    @Test
    public void readFile02() {
        String filepath = "D:\\.book\\test\\story.txt";
        FileReader fileReader = null;

        int readLen = 0;
        char[] buf = new char[8];

        try {
            fileReader = new FileReader(filepath);
            //循环读取
            //使用read
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
