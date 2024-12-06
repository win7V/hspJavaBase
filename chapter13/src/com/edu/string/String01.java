package com.edu.string;

public class String01 {

    public static void main(String[] args) {

        //String 对象用于保存 字符串  也就是一组字符序列
        String name = "jack";



        Test1 test1 = new Test1();
        System.out.println(test1.str);
        test1.change(test1.str, test1.ch);
        System.out.println(test1.str + "and");
        System.out.println(test1.ch);
    }
}

class Test1 {
    String str = new String("hsp");
    final char[] ch = {'j','a','v','a'};
    public void change(String str, char ch[]) {
        str = "java";//局部变量
        ch[0] = 'h';//数组是引用传递的
    }
}
