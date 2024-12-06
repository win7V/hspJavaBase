package com.edu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @date 3/12/2024 下午4:37
 * @explain: 正则表达式
 */
public class Regexp_ {

    public static void main(String[] args) {
        //假定编写了爬虫，从百度页面得到如下文本
        String content = "在计算机软件中，数据访问对象（data access object，DAO）" +
                "是为某种类型的数据库或其他持久性机制提供1个抽象接口的对象。" +
                "通过映射应用程序对持久层的调用，DAO提供一些特定的数据操作，而无需暴露数据库细节。" +
                "这种隔离支持单一功能原则。它分离了应用程序需要访问哪些数据，就域特定对象和数据类型（DAO的公共接口）而言，" +
                "这些需求可以用数据库管理系统（DBMS）、数据库模式等满足DAO的实现123";

        //提取文章中所有的英文单词
        //1.传统方法  使用遍历方式 代码量大 效率低
        //2.正则表达式

        //(1) 先创建一个Pattern对象 模式对象 可以理解成 就是一个正则表达式对象
        //Pattern pattern = Pattern.compile("[a-zA-Z]+");
        //Pattern pattern = Pattern.compile("[0-9]+");
        Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)");
        //(2) 创建一个匹配器对象
        //理解： 就是matcher匹配器 按照pattern(模式/样式) 到content 文本中去匹配
        //找到就返回true 否则就返回一个false
        Matcher matcher = pattern.matcher(content);
        //(3) 循环匹配
        while (matcher.find()) {
            //匹配内容 文本 放到m.group(0)
            System.out.println("找到：" + matcher.group(0));
        }
    }

}
