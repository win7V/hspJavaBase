package com.edu.properties_;

import java.io.FileOutputStream;
import java.util.Properties;

public class Properties03 {

    public static void main(String[] args) throws Exception{
        //使用Properties类来创建 配置文件 或者是修改配置文件内容

        Properties properties = new Properties();
        //创建
        //如果该文件没有key  则创建
        //如果该文件有key  则修改
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "hhh汤姆");//此处保存的是中文的unicode码
        properties.setProperty("pwd", "123bbb");
        properties.setProperty("pwd","xxxxx");
        //将k-v 存储文件中
        properties.store(new FileOutputStream("src\\mysql02.properties"),null);
    }
}
