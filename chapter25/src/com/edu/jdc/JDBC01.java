package com.edu.jdc;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {

    public static void main(String[] args) throws Exception{

        //前置工作 在项目下创建一个文件夹libs
        //讲mysql。jar拷贝到该目录下  加入到项目中

        //1.注册驱动
        Driver driver = new Driver();
        //2.得到连接
        //(1) jdbc:mysql:// 规定好表示协议  通过jdbc方式连接mysql
        //(2) localhost 主机 可以是ip地址
        //(3) 3306 监听端口
        //(4) db01 连接到的mysql数据库
        //(5) mysql连接的本质就是socket连接
        String url = "jdbc:mysql://localhost:3306/db01";
        //将 用户名和密码罚入到Properties 对象
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","zc111");
        Connection connect = driver.connect(url, properties);//connect就是网络连接
        //3.执行sql
        //String sql = "insert into actor values(null, 'ldh', 'm', '1979-10-11','110')";
        String sql = "update actor set name = 'zxc' where id = 1 ";
        //statement 执行静态SQL语句 返回其生成结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); //如果是dml语句 返回的就是影响的行数

        System.out.println(rows > 0 ? "success": "fail");
        //4.关闭连接资源
        statement.close();
        connect.close();
    }
}
