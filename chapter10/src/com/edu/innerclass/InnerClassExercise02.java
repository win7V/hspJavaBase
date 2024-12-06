package com.edu.innerclass;

public class InnerClassExercise02 {

    public static void main(String[] args) {
        CellPhone MyPhone = new CellPhone();
        MyPhone.alarmclock(new Bell() {// 传入匿名内部类(对象)作为参数
            @Override
            public void ring() {
                System.out.println("pig get up");
            }
        });

        MyPhone.alarmclock(new Bell() {// 再传入另一个匿名内部类
            @Override
            public void ring() {
                System.out.println("friend get up");
            }
        });

    }


}

class CellPhone {
    public void alarmclock(Bell bell) {//形参是Bell 接口类型 编译类型一定是Bell  运行类型不一定
        bell.ring();
    }
}

interface Bell {
    void ring();
}
