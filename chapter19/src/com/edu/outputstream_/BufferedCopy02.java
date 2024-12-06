package com.edu.outputstream_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedCopy02 {

    public static void main(String[] args) throws Exception{

        String srcFilepath = "D:\\.book\\test\\Figure_1.png";
        String destFilepath = "D:\\.book\\Figure_1.png";

        FileInputStream fis = new FileInputStream(srcFilepath);
        FileOutputStream fos = new FileOutputStream(destFilepath);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] b = new byte[1024];
        int Len;

        while((Len = bis.read(b)) != -1) {
            bos.write(b, 0, Len);
        }

        if(bis != null) {
            bis.close();
        }

        if (bos != null) {
            bos.close();
        }

    }
}
