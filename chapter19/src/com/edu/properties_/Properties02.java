package com.edu.properties_;

import java.io.FileReader;
import java.util.Properties;

public class Properties02 {

    public static void main(String[] args) throws Exception{
        //使用Properties 类来读取mysql.properties 文件

        Properties properties = new Properties();
        //加载指定的配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //把键值对k-v显示到控制台
        properties.list(System.out);
        System.out.println("=====================================");
        //根据key活得对应的值
        String user = properties.getProperty("user");
        System.out.println(user);
        String pwd = properties.getProperty("pwd");
        System.out.println(pwd);
    }
}
