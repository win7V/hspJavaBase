package com.edu.innerclass;

/*
匿名内部类的使用
 */

public class AnonymousInnerClass {

    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();

    }
}

class Outer04 {//外部类
    private int n1 = 10;

    public void method() {
        //基于接口的匿名内部类
        //1.需求：想使用IA接口 并创建对象
        //2.传统方式  写一个类  实现该接口  并创建对象
            //A tiger = new Tiger();
            //tiger.cry();
        //需求 Tiger/Dog 类只是使用一次  后面不再使用
        //可以使用匿名内部类来简化开发
        //tiger 编译类型 IA接口类型
        //tiger 运行类型 就是匿名内部类  XXXX -> Outer04$1
        /*
            底层
            class XXXX implements IA {
                @Override
                public void cry() {
                    System.out.println("tiger cry");
                }
            }
         */
        // jdk底层在创建匿名内部类 Outer04$1 立即马上就创建了 Outer04$1实例
        // 并且把地址返回给 tiger
        // 匿名内部类 使用一次就没有了  不能再使用  生成的对象 还可以再调用
        //new Outer04$1 Error
        IA tiger = new IA(){
            @Override
            public void cry() {
                System.out.println("tiger cry");
            }
        };
        System.out.println("tiger的运行类型是" + tiger.getClass());
        tiger.cry();
        tiger.cry();

        //演示基于类的匿名内部类
        //father 编译类型  Father
        //father 运行类型  匿名内部类 Outer04$2
        //底层会创建匿名内部类
        /*
            class Outer04$2 extends Father{
                @Override
                public void test() {
                    System.out.println("anonymous father test");
                }
            }
         */
        //同时也直接返回了 匿名内部类 Outer04$2 的对象
        //注意("jack") 参数列表会传递给 构造器
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("anonymous father test");
            }
        };
        //Father father = new Father("jack") 没有大括号就是普通的对象   编译类型Father  运行类型 Father
        System.out.println("father的运行类型是" + father.getClass());
        father.test();

        //基于抽象类的匿名内部类
        Animal animal= new Animal(){
            @Override
            void eat() {
                System.out.println("anonymous eat");
            }
        };

        animal.eat();
    }
}

interface IA { //接口
     void cry();
}

//class Tiger implements IA {
//    @Override
//    public void cry() {
//        System.out.println("tiger implements IA cry()");
//    }
//}

class Father {
    public Father(String name) {//构造器
        System.out.println("receieved name = " + name);
    }

    public void test() {//方法

    }
}

abstract class Animal{
    abstract void eat();
}
