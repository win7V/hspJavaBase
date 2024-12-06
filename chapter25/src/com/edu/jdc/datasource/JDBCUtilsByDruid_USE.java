package com.edu.jdc.datasource;

import com.edu.jdc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;  // 1. 导入 JUnit 5 的 Test 注解
import static org.junit.jupiter.api.Assertions.*;  // 2. 导入 JUnit 5 的断言方法


import java.sql.*;
import java.util.ArrayList;

public class JDBCUtilsByDruid_USE {

    @Test
    public void testDML() {//insert update delete

        //1.得到连接
        Connection connection = null;

        //2.组织sql
        String sql = "update actor set name = ? where id = ?";
        PreparedStatement preparedStatement = null;
        //3.创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //占位符赋值
            preparedStatement.setString(1, "nnn");
            preparedStatement.setString(2, "1");
            //执行
            preparedStatement.executeUpdate();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(null, preparedStatement, connection);
        }

    }

    @Test
    public void testSelect() {//insert update delete

        //1.得到连接
        Connection connection = null;

        //2.组织sql
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3.创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" +phone + "\t");

            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }

    }


    //土方法解决ResultSet =封装=> Arraylist
    @Test
    public void testSelectToArrayList() {//insert update delete

        //1.得到连接
        Connection connection = null;

        //2.组织sql
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<>();
        //3.创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                //把得到的resultset 的记录 封装到Actor对象 放入到list集合
                list.add(new Actor(id, name, sex, borndate, phone));

            }
            System.out.println("list集合数据 = " + list);

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }

        //因为ArrayList和connection没有任何关联  所以该集合可以复用
        //return list;

    }
}
