package com.edu.tankgame03;


import com.edu.tankgame03.EnemyTank;
import com.edu.tankgame03.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//绘图区域
//为了监听 键盘事件   实现KeyListener
//为了让Panel 不停的重绘子弹 需要将MyPanel 实现Runnable 当作一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {

    //定义我的坦克
    Hero hero = null;

    //定义敌人的坦克 放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {

        hero = new Hero(100,100);//初始化自己的坦克
        hero.setSpeed(5);

        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirect(2);

            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形 默认黑色

        //画出自己的坦克 封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        //drawTank(hero.getX() + 60, hero.getY(), g, 0, 1);

        //画出Hero射击的子弹
        if(hero.shot != null && hero.shot.isLive) {
            //System.out.println("子弹被绘制");
            //g.fill3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
            g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, true);
        }

        //画出敌人的坦克 遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        }
    }


    //x 坦克左上角x坐标
    //y 坦克左上角y坐标
    //g 画笔
    //direct 坦克方向(上下左右)
    //type 坦克类型
    public void drawTank(int x,int y, Graphics g, int direct, int type) {

        //根据不同类型坦克设置不同颜色
        switch (type) {
            case 0: //自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向  来绘制对应形状的坦克
        //direct表示方向 规定(0向上 1向右 2向下 3向左)
        switch (direct) {
            case 0: //方向向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //方向向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //方向向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //方向向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆盖
                g.drawLine(x + 30, y + 20, x , y + 20);//画出炮筒
                break;
            default:
                System.out.println("其它方向暂不处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理WASD键 按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {//按下W键
            hero.setDirect(0);
            //修改坦克坐标 y -= 1
            //hero.setY(hero.getY() - 1);
            hero.moveUp();
        } else if(e.getKeyCode() == KeyEvent.VK_D) {//按下D键
            hero.setDirect(1);
            hero.moveRight();
        } else if(e.getKeyCode() == KeyEvent.VK_S) {//按下S键
            hero.setDirect(2);
            hero.moveDown();
        } else if(e.getKeyCode() == KeyEvent.VK_A) {//按下A键
            hero.setDirect(3);
            hero.moveLeft();
        }

        //如果用户按下的是J 就需要发射
        if(e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }

        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100ms 重绘区域 刷新绘图区域 子弹就会移动

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }

    }
}
