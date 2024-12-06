package com.edu.innerclass;

public class InnerClassExercise01 {

    public static void main(String[] args) {
        //当作实参直接传递  简介高效
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("a picture");
            }
        });
        Picture picture01 = new Picture();
        picture01.show();
    }

    //静态方法  形参是接口类型
    public static void f1(IL il) {
        il.show();
    }
}


interface IL{
    void show();
}

//类->实现IL  => 硬编码
class Picture implements IL {
    @Override
    public void show() {
        System.out.println("a Picture");
    }
}
