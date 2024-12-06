package com.edu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Stu stu1 = new Stu("alice");
        Stu stu2 = new Stu("Bob");

        stu1.payFee(150.1);
        stu2.payFee(200);


        Stu.showFee();
    }
}

class Stu {
    private String name;
    private static double fee;

    public Stu(String name) {
        this.name = name;
    }

    // 当方法使用了static修饰后 该方法就是静态方法
    //静态方法可以访问静态变量
    public static void payFee(double fee) {
        Stu.fee += fee; //右边传进来的形参累积到静态变量
    }

    public static void showFee() {
        System.out.println("total fee:" + Stu.fee);
    }


}
