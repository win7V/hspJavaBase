package com.edu.interface_;

public class ExtendsVsInterface {

    public static void main(String[] args) {
        LittleMonkey wukong = new LittleMonkey("wukong");
        wukong.climbing();
        wukong.swimming();
        wukong.flying();
    }
}

class Monkey {
    private String name;
    public void climbing() {
        System.out.println(name + "会爬树...");
    }

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Fishable {
    void swimming();
}

interface Birdable {
    void flying();
}

class LittleMonkey extends Monkey implements Fishable,Birdable{
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "跟鱼学会了游泳");
    }

    @Override
    public void flying() {
        System.out.println(getName() + "跟鸟学会了飞");
    }
}
