package com.edu.poly_;

public class PolyObject {

    public static void main(String[] args) {
//        Animal animal = new Animal();
//        animal.cry();
//
//        System.out.println("====");
//
//        Dog dog = new Dog();
//        dog.cry();
//
//        System.out.println("====");
//
//        Cat cat = new Cat();
//        cat.cry();

        //编译类型是Animal  运行类型是Dog
        Animal animal = new Dog();
        animal.cry();

        animal = new Cat(); // 运行类型改为Cat
        animal.cry();


    }
}
