package com.edu.extend.improve;

public class Student {
    public String name;
    public int age;

    private  double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void showInfo() {
        System.out.println("student name " + name + " age " + age + " score " + score);
    }

}
