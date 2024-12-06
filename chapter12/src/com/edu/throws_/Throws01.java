package com.edu.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {

    public static void main(String[] args) {

    }

    public void f1() throws FileNotFoundException {
        //创建一个文件流对象
        FileInputStream fis = new FileInputStream("d://aa.txt");

    }

}


