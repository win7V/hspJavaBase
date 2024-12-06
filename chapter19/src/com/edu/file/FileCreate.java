package com.edu.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {

    public static void main(String[] args) {

    }

    @Test
    //方式1 new File(String pathname)
    public void create01() {
        String filepath = "d:\\news1.txt";
        File file = new File(filepath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式2 new File(File parent,String child) 根据父目录文件+子路径构建
    // e:\\news.txt
    public void create02() {
        File parentfile = new File("d:\\");
        String fileName = "news2.txt";
        File file = new File(parentfile, fileName);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式3 new File(String parent, String child) 根据父目录+子路径构建
    public void create03() {
        String parent = "d:\\";
        String child = "news3.txt";
        File file = new File(parent, child);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
