package com.edu.jdc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConn {

    //分析Java 连接mysql的5种方法
    //方式1
    @Test
    public void connect01() throws  Exception{
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db01";
        //将 用户名和密码罚入到Properties 对象
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","zc111");
        Connection connect = driver.connect(url, properties);//connect就是网络连接
        System.out.println("方式1 = " + connect);
    }

    //方式2
    @Test
    public void connect02() throws Exception{
        //使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/db01";
        //将 用户名和密码罚入到Properties 对象
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","zc111");
        Connection connect = driver.connect(url, properties);//connect就是网络连接
        System.out.println("方式2 = " + connect);
    }

    //方式3  使用DriverManager 替代 Driver 进行统一管理
    @Test
    public void connect03() throws Exception{
        //使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();

        //创建url和user
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "zc111";

        DriverManager.registerDriver(driver);//注册Driver驱动

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式3 = " + connection);

    }

    //方式4 使用Class.forName 自动完成注册驱动
    //该方式使用最多
    @Test
    public void connect04() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "zc111";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式4 = " + connection);

    }

    //方式5 在方式4基础上改进 增加配置文件  让连接mysql更加灵活
    @Test
    public void connect05() throws Exception {
        //通过properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式5 = " + connection);
    }


}
