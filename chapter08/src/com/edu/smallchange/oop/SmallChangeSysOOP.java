package com.edu.smallchange.oop;

/*
该类完成零钱通各项功能
将各个功能对应一个方法
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {

    //属性
    //1.定义相关变量
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    //2.完成零钱通明细
    //方法1. 可以把收益入账和消费  保存到数组   方法2 使用对象  方法3 String拼接
    String details = "-----零钱通明细-----";

    //3. 完成收益入账
    //定义新的变量
    double money = 0;
    double balance = 0; //余额
    Date date = null; //data 是java.util.Data 类型  表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 用于日期格式化

    //4.消费
    //定义新变量  保存消费的项目
    String note = "";

    //显示菜单  并可以选择
    public void mainMenu() {
        do{

            System.out.println("\n=====零钱通菜单OOP版本=====");
            System.out.println("\t1 零钱通明细");
            System.out.println("\t2 收益入账");
            System.out.println("\t3 消费");
            System.out.println("\t4 退出");
            System.out.print("请选择(1-4): ");
            key = scanner.next();

            //使用switch 分支控制
            switch (key) {
                case "1" :
                    this.detail();
                    break;
                case "2" :
                    this.income();
                    break;
                case "3" :
                    this.pay();
                    break;
                case "4" :
                    this.exit();
                    break;
                default:
                    System.out.println("菜单选择有误，重新选择");
            }

        }while(loop);
    }

    //完成零钱通明细
    public void detail() {
        System.out.println(details);

    }

    //完成收益入账
    public void income() {
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        // money 的值的范围应该校验

        if(money <= 0) {
            System.out.println("收益金额有误,本次操作不予入账");
            return;//退出方法  不再执行后面代码
        }
        balance += money;
        //拼接收益入账信息到details
        date = new Date(); //获取当前日期

        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + "目前余额:" +  balance;
    }

    public void pay() {
        System.out.println("输入消费金额：");
        money = scanner.nextDouble();
        //范围校验

        if(money > balance || money <= 0) {
            System.out.println("消费金额有误，本次消费不予操作");
            return;
        }
        System.out.println("输入消费项目名称");
        note = scanner.next();

        balance -= money;
        //拼接消费信息到details
        date = new Date(); //获取当前日期

        details += "\n消费项目:\t" + note + "\t消费金额\t-" + money + "\t" + sdf.format(date) + "\t" + "目前余额:" +  balance;
    }

    public void exit() {
        //用户输入4推出的时候  系统提示”你确定要退出吗 y/n， 必须输入正确的y/n
        //否则循环输入指令  直到输入y 或者n
        //1.定义变量 choice, 接受用户输入
        //2. while + break 来处理 接受到输入是y或者n
        //3. 退出while 再判断choice 是y还是n
        String choice = "";
        while (true){
            System.out.println("你确定要退出吗? y/n");
            choice = scanner.next();
            if("y".equals(choice) || "n".equals(choice) ) {
                break;
            }
        }

        //当用户退出while后 进行判断
        if(choice.equals("y")) {
            loop = false;
        }
        return;


    }



}
