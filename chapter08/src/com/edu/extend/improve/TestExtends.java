package com.edu.extend.improve;

public class TestExtends {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();

        pupil.name = "小明";
        pupil.age = 18;
        pupil.testing();
        pupil.setScore(75);
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "da";
        graduate.age = 18;
        graduate.testing();
        graduate.setScore(60);
        graduate.showInfo();

    }
}
