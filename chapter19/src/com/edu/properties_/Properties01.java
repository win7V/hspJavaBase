package com.edu.properties_;

import java.io.BufferedReader;
import java.io.FileReader;

public class Properties01 {

    public static void main(String[] args) throws Exception{

        //读取mysql.properties 文件  并得到ip user pwd

        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = " ";

        while((line = br.readLine()) != null) {//循环读取
            //System.out.println(line);
            String[] split = line.split("=");
            System.out.println(split[0] + "值是：" + split[1]);
        }

        br.close();
    }
}
