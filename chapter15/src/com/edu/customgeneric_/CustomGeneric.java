package com.edu.customgeneric_;

public class CustomGeneric {

    public static void main(String[] args) {

    }
}

//自定义泛型类
class Tiger<T, R, M> {
    String name;
    T t;
    R r;
    M m;

    //数组在new时候 不能确定T类型  无法开辟空间
    //T[] = new T[8]; //ERROR


    //
    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}
