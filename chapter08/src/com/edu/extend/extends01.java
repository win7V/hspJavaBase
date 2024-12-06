package com.edu.extend;

public class extends01 {
    public static void main(String[] args) {
        Pupil xiaoming = new Pupil();
        xiaoming.name = "小明";
        xiaoming.age = 8;
        xiaoming.testing();

        xiaoming.setScore(85);
        xiaoming.showInfo();
    }
}
