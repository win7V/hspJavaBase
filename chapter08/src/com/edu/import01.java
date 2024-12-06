package com.edu;

import java.util.Arrays;
import java.util.Scanner;//建议使用
//import java.util.*;//导入java.util包下的所有类

public class import01 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 20, 2, 3};
        
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
