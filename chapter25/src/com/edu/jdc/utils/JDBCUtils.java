package com.edu.jdc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//工具类  完成mysql的连接和关闭资源
public class JDBCUtils {

    //定义相关属性(4个) 因为只需要一份 因此做成static

    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    //在static代码块初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取相关的属性值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中  可以这样处理
            //将编译异常转成运行异常
            //此时调用者 可以选择捕获该异常  也可以选择默认处理该异常
            throw new RuntimeException(e);
        }
    }

    //连接数据库  返回Connection
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    /*
        1.ResultSet 结果集
        2.Statement 或 PreparedStatement
        3.Connection
        4.如果需要关闭资源  就传入对象 否则传入null
     */
    public static void close(ResultSet set, Statement statement, Connection connection){

        //判断是否为空
        try {
            if(set != null) {
                set.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
