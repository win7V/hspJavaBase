package com.edu.interface_;

public class InterfaceDetail01 {

    public static void main(String[] args) {

    }
}


//1.接口不能被实例化
//2.接口中所有方法都是public  接口中抽象方法  可以不用abstract修饰
//3.一个普通类实现接口  就必须将该接口的所有方法都实现
interface IA {

    void say();//不需要加{}方法体
    void hi();
}

class Cat implements IA{
    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }
}
//抽象类实现接口 可以不用实现方法
abstract class Tiger implements IA {

}
