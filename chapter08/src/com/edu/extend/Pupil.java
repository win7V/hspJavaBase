package com.edu.extend;

public class Pupil {
    public String name;
    public int age;

    private  double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void testing() {
        System.out.println("Pupil " + name + " is testing elementary school math");
    }

    public void showInfo() {
        System.out.println("pupil name " + name + " age " + age + " score " + score);
    }

}
