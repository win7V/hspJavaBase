package com.edu.inputstream_;

import com.edu.outputstream_.Dog;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectInputStream_ {

    public static void main(String[] args) throws Exception{

        String filepath = "D:\\.book\\test\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));

        //读取 反序列化顺序   需要和保存数据的顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readUTF());

        //System.out.println(ois.readObject());底层 Object -> Dog
        //com.edu.outputstream_.Dog@5fd0d5ae

        //o的编译类型是Object  运行类型是Dog
        Object o = ois.readObject();
        System.out.println("运行类型=" + o.getClass());
        System.out.println("dog信息为" + o);

        //如果希望调用Dog的方法 需要向下转型
        //需要将Dog类的定义 拷贝到可以引用的位置
        Dog dog = (Dog) o;
        System.out.println(dog.getName());
        System.out.println(dog.getAge());

        ois.close();

    }
}

/*
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
*/



