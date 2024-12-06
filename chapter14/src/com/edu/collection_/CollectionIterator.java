package com.edu.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {

    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义","罗贯中",10.1));
        col.add(new Book("红楼梦","曹雪芹",5.0));
        col.add(new Book("西游记","吴承恩",111));

        System.out.println("col = " + col);

        //遍历 col集合
        //先得到col对应的迭代器
        Iterator iterator = col.iterator();

        while (iterator.hasNext()) {//判断是否还有数据
            Object obj = iterator.next();
            System.out.println("obj = " + obj);
        }
        System.out.println("==========================================================");
        //增强for循环
        for(Object book : col) {
            System.out.println("book = " + book);
        }

        //快捷方式  输入I

//        for (Object o :) {
//
//        }

    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
