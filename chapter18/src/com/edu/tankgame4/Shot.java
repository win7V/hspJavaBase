package com.edu.tankgame4;

public class Shot implements Runnable {

    int x;//子弹 坐标 方向 速度
    int y;
    int direct = 0;
    int speed = 2;
    boolean isLive = true; //子弹是否存活

    //构造器


    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//射击


        while (true) {
            //休眠 50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //根据方向来改变x，y坐标
            switch (direct) {
                case 0 : //向上
                    y -= speed;
                    break;
                case 1 : //向右
                    x += speed;
                    break;
                case 2 : //向下
                    y += speed;
                    break;
                case 3 : //向左
                    x -= speed;
                    break;
            }

            //测试部分 输出x，y坐标
            System.out.println("bullet coordinate x=" + x + " y=" + y);

            //当子弹移动到面板的边界时 就应该销毁
            //当子弹碰到敌人的坦克时候 也应该结束线程
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }

        }

    }
}
