package com.edu.static_;

public class ChildGame {

    public static void main(String[] args) {

        //定义一个count   有多少小孩 加入
        int count = 0;
        Child child1 = new Child("zhangsan");

        child1.join();
        //count ++;
        child1.count++;


        Child child2 = new Child("lisi");

        child2.join();
        //count ++;
        child2.count++;

        //类变量可以通过类名来访问
        System.out.println("共有" + Child.count + "人加入");

    }
}

class Child {
    private String name;

    //定义一个变量count  是一个类变量（静态变量）  static
    //该变量最大特点就是会被Child 类 所有的 对象实例共享
    public static int count = 0;
    public Child(String name) {
        this.name = name;
    }

    public void join() {

        System.out.println(name + " join this game");
    }
}
