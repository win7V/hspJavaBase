package com.edu.reflection.question;

import com.edu.Cat;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

//反射问题的引入
public class ReflectionQuestion {


    public static void main(String[] args) throws Exception{
        //根据配置文件 re.properties 指定信息  创建Cat对象并调用方法hi

        //传统方式 new 对象-> 调用方法
//        Cat cat = new Cat();
//        cat.hi();

        //使用properties类 来读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));

        String classfullpath = properties.get("classfullpath").toString();//com.edu.Cat
        String methodName = properties.get("method").toString();//hi
        System.out.println(classfullpath + " " + methodName);

        //创建对象 传统方法 无法解决
        //new classfullpath()

        //使用反射机制解决
        //(1)加载类
        Class cls = Class.forName(classfullpath);
        //(2)通过cls 得到你加载的类com.edu.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());//运行类型
        //(3) 通过cls 得到你加载的类com.edu.Cat的methodName"hi" 的方法对象
        // 即 在反射中  可以把方法视为对象
        Method method1 = cls.getMethod(methodName);
        //(4) 通过method1 调用方法  ： 通过方法对象实现调用方法
        System.out.println("============================");
        method1.invoke(o);//传统方法  对象.方法()    反射机制方法.invoke(对象)


    }
}
