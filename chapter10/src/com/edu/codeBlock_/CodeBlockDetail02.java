package com.edu.codeBlock_;

public class CodeBlockDetail02 {

    public static void main(String[] args) {
        BBB bbb = new BBB();
    }
}

class AAA {

    {
        System.out.println("AAA的代码块");
    }
}

class BBB extends AAA {
    //super()
    //调用本类普通代码块


    public BBB() {
        System.out.println("BBB 构造器被调用");
    }

    {
        System.out.println("BBB 的普通代码块被调用");
    }
}

