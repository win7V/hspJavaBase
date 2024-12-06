package com.edu.exit_;

public class ThreadExit {

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        //如果希望main线程去控制t1 线程的终止 必须可以修改loop变量
        //让t1 退出run方法  从而终止t1线程  ->  通知方式

        //让主线程休眠10s 再通知t1线程退出
        Thread.sleep(10000);
        t1.setLoop(false);
    }
}

class T extends Thread {

    int count = 0;

    //设置一个控制变量
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("T running" + (++ count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
