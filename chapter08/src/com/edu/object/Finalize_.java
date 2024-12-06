package com.edu.object;

public class Finalize_ {

    public static void main(String[] args) {

        Car car = new Car("bmw");
        car = null;
        //这时Car 对象就是一个垃圾   垃圾回收器 就会回收对象,在销毁对象前 会调用该对象Finalize方法
        //此时就可以在finalize中 写自己的业务逻辑

        System.gc();//主动运行垃圾回收器
        System.out.println("program exit");
    }
}

class Car {
    private  String name;

    public Car(String name) {
        this.name = name;
    }

    //重写finalize

    @Override
    protected void finalize() throws Throwable {
        //super.finalize();
        System.out.println("xiaohuiqiche " + name);
        System.out.println("shifangziyuan");
    }
}
