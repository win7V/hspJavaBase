package com.edu.writer_;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {

    public static void main(String[] args) {

        String filepath = "D:\\.book\\test\\hello.txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filepath);
            //写入单个字符
            fileWriter.write('H');

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
