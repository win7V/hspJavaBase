package com.edu.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//演示小球通过键盘控制上下左右移动 -> 讲解Java的事件控制
public class BallMove extends JFrame{// 窗口
    MyPanel mp = null;
    public static void main(String[] args) {
        new BallMove();
    }

    //构造器
    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        //窗口JFrame 对象可以监听到键盘事件 即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//面板 可以画出小球
//KeyListener 监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以移动  把左上角坐标 设置为变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    //有字符输出 该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下时， 该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {

    }

    //当某个键释放(松开) 该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

        //System.out.println((char)e.getKeyCode() + "被按下去了");

        //根据用户按下的不同键 来处理小球的移动
        //在Java中会给每一个键 分配一个值(int)
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {//向下的箭头 对应的code值
            y += 5;
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 5;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 5;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 5;
        }

        //让面板重绘
        this.repaint();

    }
}

