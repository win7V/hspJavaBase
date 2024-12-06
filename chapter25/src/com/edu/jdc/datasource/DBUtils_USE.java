package com.edu.jdc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class DBUtils_USE {

    //使用apache-DBUtils 工具类 + druid 完成对表的crud操作

    @Test
    public void testQueryMany() throws Exception{ //返回结果是多行的情况

        //1.得到连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils 类先引入DBUtils相关jar文件 加入到本project
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.执行相关的方法 返回ArrayList结果集
        String sql = "select * from actor where id >= ?";
        //(1) query方法就是执行sql语句  得到resultset---封装到---> ArrayList 集合中
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql: 执行的sql语句
        //(5) new BeanListHandler<>(Actor.class):  在将resultset取出来 --> Actor对象 -->封装到ArrayList
        //    底层使用反射机制 获取Actor类属性  然后进行封装
        //(6) 1  给sql语句中？赋值  可以有多个值  因为是可变参数 Object...params
        //(7) 底层得到的resultset 会在query中关闭 关闭PreparedStatement
        List<Actor> list
                = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合信息");
        for(Actor actor: list) {
            System.out.println(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成  返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws Exception{
        //1.得到连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils 类先引入DBUtils相关jar文件 加入到本project
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.执行相关的方法 返回ArrayList结果集
        String sql = "select * from actor where id = ?";
        // 返回的单行记录<--->单个对象， 使用Handler 是 BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
        System.out.println(actor);

        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成查询结果是单行单列的情况  返回的就是object
    @Test
    public void testScalar() throws Exception{
        //1.得到连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils 类先引入DBUtils相关jar文件 加入到本project
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.执行相关的方法 返回单行单列
        String sql = "select name from actor where id = ?";

        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(obj);


        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示 apache-dbutils + druid 完成dml (update insert delete)
    @Test
    public void testDML() throws Exception{
        //1.得到连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils 类先引入DBUtils相关jar文件 加入到本project
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.组织sql  完成update insert  delete
        String sql = "update actor set name = ? where id = ?";

        //(1) 执行dml操作是queryRunner.update()
        //(2) 返回值是受影响的行数
        int affectedRow = queryRunner.update(connection, sql, "newjeans", 1);
        System.out.println(affectedRow > 0 ? "执行成功" : "未影响到数据库");



        JDBCUtilsByDruid.close(null, null, connection);
    }
}
