package com.edu.codeBlock_;

public class CodeBlock01 {

    public static void main(String[] args) {
        Movie movie1 = new Movie("titan");
        Movie movie2 = new Movie("a1", 150);
        Movie movie3 = new Movie("b1", 150.2, "jame");



    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    //3个构造器 -> 重载

    //三个构造器有相同的语句  造成冗余   可以把相同部分放入到代码块

    {
        System.out.println("打开屏幕");
        System.out.println("广告");
        System.out.println("真开始");
    }

    public Movie(String name) {
        System.out.println("movie(string)被调用");
        this.name = name;
    }

    public Movie(String name, double price) {

        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {

        this.name = name;
        this.price = price;
        this.director = director;
    }
}
