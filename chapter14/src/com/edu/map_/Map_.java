package com.edu.map_;

import java.util.HashMap;
import java.util.Map;

public class Map_ {

    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("no1", "jack"); //k - v
        map.put("no2", "lili"); //k - v
        map.put("no1", "jimp"); //有相同k 等价于替换

        System.out.println(map);
    }
}
