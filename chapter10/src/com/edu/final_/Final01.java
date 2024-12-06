package com.edu.final_;

public class Final01 {

    public static void main(String[] args) {

    }
}


//如果要求A类不能被其它类继承
//用final修饰
final class A {

}

//class B extends A { }

class C {
    //如果想让父类某个方法无法被子类重写   用final修饰
    //final public void hi() {}
    public void hi() {}
}

class D extends C {
    @Override
    public void hi() {
        System.out.println("D.hi");
    }
}