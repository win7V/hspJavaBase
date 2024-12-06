package com.edu.api;

import java.net.InetAddress;

public class API_ {

    //演示INetAddress 类的使用
    public static void main(String[] args) throws Exception{
        //获取本机INetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // LAPTOP-EQR6H5FP/10.60.140.110

        //根据指定的主机名 获取INetAddress对象
        InetAddress host1 = InetAddress.getByName("LAPTOP-EQR6H5FP");
        System.out.println("host1 = " + host1);

        //根据域名返回 InetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2 = " + host2);


    }
}
