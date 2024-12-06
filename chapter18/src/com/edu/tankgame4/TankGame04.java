package com.edu.tankgame4;

import javax.swing.*;

public class TankGame04 extends JFrame {

    //定义一个MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {

        TankGame04 tankGame01 = new TankGame04();
    }

    public TankGame04() {
        mp = new MyPanel();
        //将mp放入到Thread 并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);//增加监听事件  让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
