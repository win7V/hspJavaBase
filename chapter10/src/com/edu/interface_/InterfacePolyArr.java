package com.edu.interface_;

public class InterfacePolyArr {

    public static void main(String[] args) {
        //多态数组
        Usb[] usbs = new Usb[2];//接口类型的数组

        usbs[0] = new MyPhone();
        usbs[1] = new MyCamera();

        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();//动态绑定
            //类型的向下转型
            if (usbs[i] instanceof MyPhone) {
                ((MyPhone) usbs[i]).call();
            }
            if (usbs[i] instanceof MyCamera) {
                ((MyCamera) usbs[i]).pick();
            }
        }
    }
}

interface Usb {
    void work();
}

class MyPhone implements Usb {
    public void call() {
        System.out.println("MyPhone call");
    }

    @Override
    public void work() {
        System.out.println("MyPhone work");
    }
}

class MyCamera implements Usb {
    public void pick() {
        System.out.println("MyCamera pick");
    }

    @Override
    public void work() {
        System.out.println("MyCamera work");
    }
}
