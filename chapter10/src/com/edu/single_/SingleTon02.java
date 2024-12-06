package com.edu.single_;

/*
演示懒汉式单例模式
 */

public class SingleTon02 {

    public static void main(String[] args) {
        Cat cat = Cat.getInstance();

        System.out.println(cat.toString());
    }
}

//希望在程序创建过程中 只能创建一个cat
class Cat {
    private String name;
    private static Cat cat;

    //1.构造器私有化
    //2.定义一个static对象
    //3.提供一个public的static方法，可以返回一个Cat对象
    //4.懒汉式  只有当用户使用getInstance时候 才返回cat对象  后面再次调用时 会返回上次创建的对象
    private Cat(String name) {
        System.out.println("Cat构造器被调用");
        this.name = name;
    }

    public static Cat getInstance() {
        if(cat == null ) {//还未创建cat对象
            cat = new Cat("mimi");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
