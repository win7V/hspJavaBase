package com.edu.qqclient.service;

import com.edu.qqcommon.Message;
import com.edu.qqcommon.MessageType;
import com.edu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {

    //因为User可能在其它地方使用user信息  所以做成一个成员属性
    private User u = new User();
    //Socket 也可能在其它地方使用 因此做成属性
    private Socket socket;

    //根据userId和pwd 到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;//临时局部变量  如果登录成功 设置为true
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        //连接到服务端 发送u对象
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送User对象

            //读取从Server端回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message)ois.readObject();

            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) { //登录成功
                //启动一个线程 让该线程持有这个socket
                //创建一个和Server端保持通信的线程 -> ClientConnectServerThread
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                //启动客户端线程
                ccst.start();
                //为了后面客户端的一个扩展 将线程放入到集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, ccst);
                b = true;
            } else {
                //登录失败 不能启动和服务器通信的线程 关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    //向Server请求在线用户列表
    public void onlineFriendList() {
        //发送Message 类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        //发送给Server
        try {
            //根据当前的userId 从管理线程的集合中 得到对应的线程
            //根据对应的线程 得到相关联的Socket
            //根据Socket 得到OutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //编写方法 退出客户端  并给服务端发送一个退出系统的message对象
    public void logout() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//要指定我是哪个客户端

        //发送message
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + "推出了系统。。。");
            System.exit(0); //结束该进程
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
