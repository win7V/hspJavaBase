package com.edu.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//文件上传客户端
public class TCPFileUploadClient {

    public static void main(String[] args) throws Exception{

        //客户端连接服务端 得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        String filepath = "D:\\.book\\test\\Figure_1.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));

        //bytes 就是filepath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流 将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes); //将文件对应的字节数组的内容 写入到数据通道
        bis.close();
        socket.shutdownOutput();//设置写入数据的结束标记

        //接受从服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        //输入流转字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);


        //关闭相关流
        bos.close();
        socket.close();

    }
}
