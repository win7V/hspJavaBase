package com.edu.qqclient.service;

import java.util.HashMap;

/*
管理Client连接到Server的线程的类
 */
public class ManageClientConnectServerThread {
    //把多个线程放入到hashmap集合 key就是用户id value 就是线程
    private static HashMap<String ,ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入到集合中
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread ccst) {
        hm.put(userId, ccst);
    }
    //通过userId 可以得到对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }

}
