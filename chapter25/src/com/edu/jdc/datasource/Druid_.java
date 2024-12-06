package com.edu.jdc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {

    public static void main(String[] args) throws Exception{
        //1. 加入Druid jar
        //2. 加入配置文件druid.properties 将该文件拷贝项目的src目录
        //3. 创建Properties对象 读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //4.创建一个指定参数的数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println("连接成功");
        connection.close();


    }
}
