package com.edu.list_;


import java.util.ArrayList;
import java.util.List;

public class List01 {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("jack");
        list.add(123);

        System.out.println(list);
        for (Object o : list) {
            System.out.println("o = " + o);
        }
        

    }
}
