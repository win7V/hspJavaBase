package com.edu.jdc.resultset_;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ResultSet_ {

    public static void main(String[] args)throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //1.    注册驱动
        Class.forName(driver);
        //2.    得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3.    得到Statement
        Statement statement = connection.createStatement();
        //4.    组织Sql
        String sql = "select id, name, sex, borndate from actor";
        //执行给定SQL语句 该语句返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);

        //5. 使用while 取出数据
        while (resultSet.next()) {  //让光标向后移动  如果没有更多行  返回false

            int id =  resultSet.getInt(1);//获取该1行第一列数据
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date + "\t");
        }
        //6. 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
