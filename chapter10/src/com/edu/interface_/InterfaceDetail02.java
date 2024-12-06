package com.edu.interface_;

public class InterfaceDetail02 {

    public static void main(String[] args) {

    }
}

interface IB {
    //接口中的属性 只能是final 而且是 public static final 修饰符
    int n1 = 10;//等价于 public static final int n1 = 10;
    void hi();
}

interface IC {
    void say();
}

//接口不能继承类  但是可以继承其它接口
interface ID extends IB,IC {

}

//一个类 可以同时实现多个接口
class Pig implements IB,IC {
    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}
