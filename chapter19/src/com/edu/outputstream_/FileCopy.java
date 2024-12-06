package com.edu.outputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {

        //完成文件拷贝 将D:\.book\test\Figure_1.png 拷贝到 D:\.book\
        //1.创建文件输入流  将文件读入到程序
        //2.创建文件输出流 将读取到的文件数据  写入到指定的文件

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        String srcFilepath = "D:\\.book\\test\\Figure_1.png";
        String destFilepath = "D:\\.book\\Figure_1.png";

        try {

            fileInputStream = new FileInputStream(srcFilepath);
            fileOutputStream = new FileOutputStream(destFilepath);

            //定义一个字节数组  提高读取效率
            byte[] buff = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buff)) != -1) {
                //读取到后 就写入到文件
                //边读边写
                fileOutputStream.write(buff, 0, readLen);
            }
            System.out.println("拷贝成功");

        } catch (IOException e) {


            e.printStackTrace();
        } finally {
            try {
                if(fileInputStream != null) {
                    fileInputStream.close();
                }
                if(fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
