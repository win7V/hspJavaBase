package com.edu.jdc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class C3P0_ {

    //方式1 相关参数在程序中指定user url password
    @Test
    public void testC3P0_01() throws Exception{

        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2. 通过配置文件mysql.properties 获取相关连接信息

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //读取相关的属性值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 ComboPooledDataSource 设置相关参数
        //连接的管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        //测试连接池效率  测试对mysql 5000次操作
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//这个方法就是从DataSource接口实现的
            //System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("连接总耗时" + (end - start));//391
    }

    //第二种方法 使用配置文件模板来完成

    //1. 将c3p0 提供的 c3p0.config.xml 拷贝到 src目录下
    //2. 该文件指定了连接数据库和数据库连接池相关信息
    @Test
    public void testC3P0_02() throws Exception{

        ComboPooledDataSource mysqlPool = new ComboPooledDataSource("mysqlPool");

        //测试5000次连接mysql
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = mysqlPool.getConnection();
            //System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("连接总耗时" + (end - start));//168

    }

}
