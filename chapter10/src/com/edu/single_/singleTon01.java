package com.edu.single_;

public class singleTon01 {

    public static void main(String[] args) {
        // alice = new Girlfriend("alice");
        Girlfriend gf = Girlfriend.getInstance();
        System.out.println(gf.toString());
    }
}


//有一个类 girfriend
//只能有一个实例

class Girlfriend {
    private String name;

    //为了能够在静态方法中返回gf  创建静态对象
    private static Girlfriend gf = new Girlfriend("alice");
    //如何保证只能创建一个 girlfriend
    //1.构造器私有化
    //2.在类的内部直接创建
    //3.提供一个公共静态方法  返回gf对象
    private Girlfriend(String name) {
        this.name = name;
    }

    public static Girlfriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "Girlfriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
