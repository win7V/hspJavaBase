package com.edu.object;

public class ToString {

    public static void main(String[] args) {
    /*
    Object的toString()源码
    (1) getClass().getName() 类的全类名
    (2) Integer.toHexString(hashCode()) 将对象的hashcode值转为16进制字符串
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    */


        Monster monster = new Monster("xiaoyao", "xunshan", 1500);
        System.out.println(monster.toString() + "  hashcode = " + monster.hashCode());
        System.out.println(monster);//输出一个对象  默认调用toString
    }


}



class Monster{
    private String name;
    private String job;
    private double sal;

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    //重写toString 输出对象属性
    //alt + ins -> toString


    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}