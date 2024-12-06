package com.edu.socket;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP01Client {

    public static void main(String[] args) throws Exception{
        //客户端
        //1.连接服务端(ip, 端口)
        //连接本机的 9999端口  如果连接成功  返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//本机，端口号
        System.out.println("Client socket = " + socket.getClass());
        //2.连接上后 生成Socket 通过socket.getOutputStream()
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流 写入数据到 数据通道
        outputStream.write("hello, server".getBytes());
        //4.关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
