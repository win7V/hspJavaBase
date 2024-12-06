package com.edu.threaduse;

import java.util.Date;

public class Thread02 {

    public static void main(String[] args) {
//        Dog dog = new Dog();
//        //dog.start() 这里不能直接start
//
//        Thread thread = new Thread(dog);
//        thread.start();

        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Animal{}

class Tiger extends Animal implements Runnable {

    @Override
    public void run() {
        System.out.println("tiger aoao");
    }
}


class ThreadProxy implements Runnable{ //线程代理

    private Runnable target = null;//属性 类型是Runable

    @Override
    public void run() {
        if(target != null){
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();//真正实现多线程方法
    }

    public void start0() {
        run();
    }
}

class Dog implements Runnable {

    int count = 0;
    @Override
    public void run() {

        while (true) {
            System.out.println("dog wangwang" + (++count) + " 线程名称" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 80) {
                break;
            }
        }

    }
}
