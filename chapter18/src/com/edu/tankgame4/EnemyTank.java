package com.edu.tankgame4;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{

    //在敌人的坦克类 使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {

            //如果子弹数为0并且坦克存活 就创建一颗子弹放入到shots集合  并启动
            if(isLive && shots.size() == 0) {

                Shot s = null;

                //判断坦克方向  创建对应的子弹
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            //根据坦克的方向继续移动
            switch (getDirect()) {
                case 0://上
                    //让坦克保持一个方向 走30步
                    for (int i = 0; i < 30; i++) {
                        if(getY() > 0) {
                            moveUp();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://右

                    for (int i = 0; i < 30; i++) {
                        if(getX() + 60 < 1000) {
                            moveRight();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://下

                    for (int i = 0; i < 30; i++) {
                        if(getY() + 60 < 750) {
                            moveDown();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://左

                    for (int i = 0; i < 30; i++) {
                        if(getX() > 0) {
                            moveLeft();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            //随机改变坦克方向 [0,4) 再取整 即 0 1 2 3
            setDirect((int)(Math.random() * 4));
            //写并发程序  一定要考虑该线程何时结束
            if(!isLive) {
                break;//退出线程
            }
        }
    }
}
