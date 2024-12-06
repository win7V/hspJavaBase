package com.edu.innerclass;

public class StaticInnerClass01 {

    private static String staticOuterMessage = "Hello from Static Outer Class"; // 外部类的静态成员
    private String nonStaticOuterMessage = "Hello from Non-Static Outer Class"; // 外部类的非静态成员

    // 静态内部类
    // 放在外部类的成员位置
    // 使用static修饰
    public static class StaticInnerClass {
        private String innerMessage = "Hello from Static Inner Class"; // 静态内部类的成员

        // 静态内部类的方法
        public void displayMessages() {
            System.out.println(staticOuterMessage); // 可以访问外部类的静态成员
            // System.out.println(nonStaticOuterMessage); // 无法访问外部类的非静态成员，编译错误
            System.out.println(innerMessage); // 访问内部类成员
        }
    }

    public static void main(String[] args) {
        // 直接创建静态内部类的实例（不需要外部类的实例）
        StaticInnerClass01.StaticInnerClass inner = new StaticInnerClass01.StaticInnerClass();

        // 调用静态内部类的方法
        inner.displayMessages();
    }
}
