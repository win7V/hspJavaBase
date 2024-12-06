package com.edu.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {

    public static void main(String[] args) throws Exception{
        //服务端
        //1.在本机9999端口监听  等待连接
        // 细节  要求在本机 没有其它服务监听9999
        //      ServerSocket 可以通过accept() 返回多个Socket[多个客户端连接服务器的多并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听  等待连接");

        //2.当没有客户端连接9999端口 程序会  阻塞 等待连接
        //  如果有客户端连接  则会返回一个Socket对象  程序继续
        Socket socket = serverSocket.accept();

        System.out.println("Server socket = " + socket.getClass());

        //3.通过socket.getInputStream() 读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //4.IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while((readLen = inputStream.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));//根据读取到的实际长度 显示内容
        }


        //5.获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, client".getBytes());
        //设置结束标记
        socket.shutdownOutput();
        //6.关闭流和socket
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端关闭");
    }
}
