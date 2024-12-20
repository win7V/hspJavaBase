package com.edu.tankgame03;

public class Hero extends Tank {

    //定义一个Shot对象  表示一个射击(线程)
    Shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    //射击
    public void shotEnemyTank() {

        //创建shot对象  要根据当前Hero对象的位置和方向来创建shot
        switch (getDirect()) {//得到Hero的方向
            case 0://向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://向右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2://向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3://向左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        //启动shot线程
        new Thread(shot).start();
    }
}
