package com.edu.interface_;

public class Computer {

    //编写一个方法

    public void work(UsbInterface usbInterface) {
        //通过接口调用方法
        usbInterface.start();
        usbInterface.end();
    }
}
