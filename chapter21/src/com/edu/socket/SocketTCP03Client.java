package com.edu.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP03Client {

    public static void main(String[] args) throws Exception{
        //客户端  字符流
        //1.连接服务端(ip, 端口)
        //连接本机的 9999端口  如果连接成功  返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//本机，端口号
        System.out.println("Client socket = " + socket.getClass());
        //2.连接上后 生成Socket 通过socket.getOutputStream()
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流 写入数据到 数据通道  使用字符流
        //outputStream.write("hello, server".getBytes());  //字节流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));//字节输出流转->字符输出流
        bufferedWriter.write("hello, server 字符流");
        bufferedWriter.newLine();//插入一个换行符 表示写入的内容结束  要求另外一方使用readLine()
        bufferedWriter.flush();// 如果使用字符流  需要手动刷新  否则数据不会写入数据通道
        // 设置结束标记
        socket.shutdownOutput();


        //4.通过socket.getInputStream() 读取Server端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf)) != -1){
//            System.out.println(new String(buf, 0, readLen));
//        }
        //4.获取和socket关联的输入流  读取数据(字符) 并显示
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        //5.关闭流对象和socket
        bufferedReader.close(); //关闭外层  一般后打开的先关闭
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
