package com.edu.object;

public class HashCode {

    public static void main(String[] args) {
        AA aa = new AA();
        AA aa1 = new AA();
        AA aa2 = aa;

        System.out.println(aa.hashCode());
        System.out.println(aa1.hashCode());
        System.out.println(aa2.hashCode());
    }
}

class AA {}
