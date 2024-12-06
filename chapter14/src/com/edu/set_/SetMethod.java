package com.edu.set_;

import java.util.HashSet;
import java.util.Set;

public class SetMethod {

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("jame");
        set.add("jack");
        set.add("ame");
        set.add(null);

        System.out.println(set);

        set.remove("jame");
        System.out.println(set);

        set.add("hhh");
        System.out.println(set);

        for (Object o : set) {
            System.out.println(o);
        }

        //set接口不能用索引遍历

    }
}
