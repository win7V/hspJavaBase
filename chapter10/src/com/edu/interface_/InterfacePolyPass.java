package com.edu.interface_;

/*
演示多态传递
 */

public class InterfacePolyPass {

    public static void main(String[] args) {

        //接口类型的变量可以指向 实现了该接口的类的对象实例
        IG ig = new Teacher();
        //如果IG 继承了IH 接口  而Teacher 类实现了 IG接口
        //那么 实际上就相当于 Teacher类也实现了IH接口
        //这就是所谓的 接口多态多态传递 现象
        IH ih = new Teacher();
    }
}

interface IH {
    void hi();
}
interface IG extends IH { }

class Teacher implements IG {
    @Override
    public void hi() {

    }
}