package com.edu.interface_;

public class Interface02 {

    public static void main(String[] args) {

    }
}

//如果一个类implements实现接口
//需要将该接口所有抽象方法都实现
class A implements AInterface {

    @Override
    public void hi() {
        System.out.println("A hi");
    }
}
