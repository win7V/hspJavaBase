package com.edu.innerclass;

/*
演示局部内部类的使用
 */
public class LocalInnerClass {//外部其他类 不能直接访问 局部内部类

    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();


    }
}

class Outer02 {
    private int n1 = 100;
    private void m2() {
        System.out.println("Outer02 m2");
    }
    public void m1() { //方法
        //局部内部类是定义在外部类的局部位置  通常在方法
        //不能添加访问修饰符 可以用final 修饰
        //作用域 仅仅定义在它的方法或代码块中
        class Inner02 {//局部内部类(本质仍然是一个类)
            //可以直接访问外部类的所有成员 包含私有的
            private int n1 = 800;
            public void f1() {

                //如果外部类和局部内部类的成员重名  默认遵循就近原则 如果想访问外部类的成员 可以使用 外部类名.this.成员 去访问
                System.out.println("n1 = " + n1);
                //Outer02.this 本质就是外部类的对象  即哪个对象调用了m1 Outer02.this 就是哪个对象
                System.out.println("Outer02.this.n1=" + Outer02.this.n1);
                m2();
            }
        }
        class Inner03 extends Inner02 {

        }
        //外部类在方法中  可以创建Inner02对象  然后调用 方法 即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}


