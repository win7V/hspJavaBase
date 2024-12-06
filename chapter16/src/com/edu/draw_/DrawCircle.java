package com.edu.draw_;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{//JFrame 对应窗口  可以理解为一个画框

    private MyPanel mp = null;
    public static void main(String[] args) {

        new DrawCircle();
    }

    public DrawCircle() {
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口
        this.add(mp);
        //设置窗口的大小
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭后就真正退出
        this.setVisible(true);//可以显示;
    }
}

//1.先定义一个MyPanel() 继承JPanel

class MyPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类方法完成初始化
        g.drawOval(10,10,100,100);
        //g.drawOval(0,0,100,100);
        g.drawOval(100,100,200,100);

        g.drawLine(10,10,100,100);

        g.drawRect(10,10,20,30);

        g.setColor(Color.red);
        g.fillRect(50,50,100,100);

        //画图片
        //获取图片资源 /1.png 表示在该项目的根目录去获取1.png图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.png"));
//        g.drawImage(image,10,10,837,613,this);
        g.setColor(Color.blue);
        g.setFont(new Font("隶属", Font.BOLD,50));
        g.drawString("你好",100,100);
    }
}

