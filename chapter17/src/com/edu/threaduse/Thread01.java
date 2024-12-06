package com.edu.threaduse;

public class Thread01 {

    public static void main(String[] args) throws InterruptedException{
        Cat cat = new Cat();
        cat.start();//启动线程

        //当main线程启动一个子线程 Thread-0 主线程不会阻塞 会继续执行
        //这时 主线程和子线程 交替执行
        System.out.println("主线程继续执行 名字为" + Thread.currentThread().getName());
        for (int i = 0; i < 80; i++) {
            System.out.println("main i = " + i);
            Thread.sleep(1000);
        }
    }
}

//当一个类继承了Thread类   该类就可以当作线程使用
class Cat extends Thread {

    int times = 0;

    @Override
    public void run() {//重写run方法 写上自己的逻辑

        do {
            times ++;
            System.out.println("meme" + times + " 线程名:" + Thread.currentThread().getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(times < 80);

    }
}
