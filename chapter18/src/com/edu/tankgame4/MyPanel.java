package com.edu.tankgame4;


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
    //定义一个Vector  用于存放炸弹
    //说明 当子弹击中坦克时 加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    //定义三张炸弹图片 用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {

        hero = new Hero(100,100);//初始化自己的坦克
        hero.setSpeed(5);

        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置方向
            enemyTank.setDirect(2);
            //启动敌人坦克线程 让其动起来
            new Thread(enemyTank).start();
            //给该enemyTank 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20,enemyTank.getY() + 60, enemyTank.getDirect());
            //加入enemyTank的Vector 成员
            enemyTank.shots.add(shot);
            //启动shot对象
            new Thread(shot).start();
            //加入
            enemyTanks.add(enemyTank);

        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形 默认黑色


        if(hero.isLive && hero != null) {
            //画出自己的坦克 封装方法
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
            //drawTank(hero.getX() + 60, hero.getY(), g, 0, 1);
        }


        //画出Hero射击的子弹

        //单颗子弹的情况
//        if(hero.shot != null && hero.shot.isLive) {
//            //System.out.println("子弹被绘制");
//            //g.fill3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
//            g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, true);
//        }

        //将hero的子弹集合 shots 遍历输出
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if(shot != null && shot.isLive) {
            g.draw3DRect(shot.x, shot.y, 1, 1, true);
            } else{//如果该shot对象已经无效 应从集合中拿出
                hero.shots.remove(shot);
            }
        }

        //如果bombs 集合中有对象 就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if(bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60,60,this);
            } else if(bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60,60,this);
            } else  {
                g.drawImage(image3, bomb.x, bomb.y, 60,60,this);
            }
            //让这个炸弹生命值减少
            bomb.lifeDown();
            //如果bomb life 为0 就从bombs集合中删除
            if(bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        //画出敌人的坦克 遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //从Vector 取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);

            //判断当前坦克是否存活
            if (enemyTank.isLive) {

                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);

                //画出 enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if(shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, true);
                    } else {
                        //从Vector移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }

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

    //如果我们的坦克可以发射多个子弹
    //在判断为我方子弹是否击中敌人的坦克时， 就需要把我们的子弹集合中
    //所有的子弹都取出  和敌人的所有坦克  进行判断
    public void hitEnemyTank() {

        //遍历我们的子弹
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);
            //判断是否击中了敌人的坦克
            if(shot != null && shot.isLive) { //当前我的子弹还存活
                //遍历敌人所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    //编写方法 判断敌人坦克的子弹是否击中我方坦克
    public void hitHero() {
        //遍历所有的敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank对象的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                //判断shot是否击中我方坦克
                if(hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }

    //编写方法 判断我方的子弹是否击中敌人坦克
    //何时判断 我方的子弹是否击中敌人坦克 ？ 放到run
    public void hitTank(Shot s, Tank enemyTank) {

        //判断s 击中坦克
        switch (enemyTank.getDirect()) {
            case 0:
            case 2://敌人向上或者向下时候  样子相同
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                 &&s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //当我们的子弹击中敌人坦克后 将enemyTank 从Vector 中拿掉
                    enemyTanks.remove(enemyTank);
                    //创建一个Bomb对象  加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3://敌人向左或者向右时候  样子相同
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                 &&s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //创建一个Bomb对象  加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
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
            if(hero.getY() > 0) {
                hero.moveUp();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_D) {//按下D键
            hero.setDirect(1);
            if(hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_S) {//按下S键
            hero.setDirect(2);
            if(hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_A) {//按下A键
            hero.setDirect(3);
            if(hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        //如果用户按下的是J 就需要发射
        if(e.getKeyCode() == KeyEvent.VK_J) {

            //判断该当前hero的子弹是否销毁 发射一颗子弹的情况
            //if(hero.shot == null || !hero.shot.isLive) {
            //    hero.shotEnemyTank();
            //}

            //发射多颗子弹的情况
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

            hitEnemyTank();

            //判断敌人坦克是否击中我们
            hitHero();


            this.repaint();
        }

    }
}
