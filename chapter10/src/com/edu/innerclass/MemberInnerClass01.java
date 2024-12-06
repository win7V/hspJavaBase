package com.edu.innerclass;

public class MemberInnerClass01 {

    private String outerMessage = "Hello from Outer Class"; // 外部类的私有成员

    // 成员内部类
    public class InnerClass {
        private String innerMessage = "Hello from Inner Class"; // 内部类的私有成员

        // 内部类的方法，可以访问外部类的私有成员
        public void displayMessages() {
            System.out.println(outerMessage); // 访问外部类成员
            System.out.println(innerMessage); // 访问内部类成员
        }
    }

    public static void main(String[] args) {
        // 创建外部类的实例
        MemberInnerClass01 outer = new MemberInnerClass01();

        // 使用外部类实例创建内部类的实例
        MemberInnerClass01.InnerClass inner = outer.new InnerClass();

        // 调用内部类的方法
        inner.displayMessages();
    }
}
