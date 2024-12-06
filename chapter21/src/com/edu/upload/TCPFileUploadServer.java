package com.edu.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//文件上传的服务端
public class TCPFileUploadServer {

    public static void main(String[] args) throws Exception{

        //1.服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听");
        //2.等待连接
        Socket socket = serverSocket.accept();

        //3.读取客户端发送的数据
        // 通过socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //将得到的bytes数组  写入到指定的路径  就得到一个文件
        String desFilePath = "src\\figure2.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFilePath));
        bos.write(bytes);
        bos.close();

        //向客户端回复“收到图片”
        //通过socket获取输出流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("成功收到客户端发来的图片");
        writer.flush();//把内容刷新到数据通道
        socket.shutdownOutput();//写入结束标记

        //关闭其它资源
        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();


    }
}
