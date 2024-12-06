package com.edu.enum_;

public class Enumeration01 {

    public static void main(String[] args) {
        System.out.println(Seasons.SPRING);
    }
}

enum Seasons{

    //将定义常量对象写在最前面
    SPRING("spring","warm"),// 常量名(实参列表)
    SUMMER("summer","hot"),
    AUTUMN("autumn","cool"),
    WINTER("winter","cold");


    private String name;
    private String desc;

    private Seasons(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
