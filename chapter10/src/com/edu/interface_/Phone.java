package com.edu.interface_;

//Phone 类 实现 UsbInterface
//需要实现UsbInterface接口 规定 /声明的方法
public class Phone implements UsbInterface {

    @Override
    public void start() {
        System.out.println("Phone start");
    }

    @Override
    public void end() {
        System.out.println("Phone end");
    }
}
