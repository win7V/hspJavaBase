package com.edu.qqserver.service;

import com.edu.qqcommon.Message;
import com.edu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/*
该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId;//连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {//这里线程处于run状态  可以发送/接收消息

        while (true) {
            try {
                System.out.println("服务器端和客户端" + userId + "保持通信，读取信息。。。");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message
                //先判断该message类型 然后做相应的业务处理
                //如果读取到的是 客户端请求的在线好友列表
                if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    //Client请求在线用户列表
                    /*
                    在线用户列表形式:100 200 老大
                     */
                    System.out.println(message.getSender() + "请求在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回
                    //构建一个Message对象
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //返回给Client
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) { //客户端退出
                    System.out.println(message.getSender() + "退出");
                    //将该客户端对应线程 从集合中移除
                    ManageClientThreads.remove(message.getSender());
                    socket.close();//关闭连接
                    //退出线程
                    break;

                } else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //服务器端起到一个转发作用
                    //根据message获取到getterId, 然后再得到对应的线程
                    ServerConnectClientThread scct = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    //从对应线程中得到对应socket的对象输出流 将message对象转发给指定的客户端
                    ObjectOutputStream oos = new ObjectOutputStream(scct.getSocket().getOutputStream());
                    oos.writeObject(message);//转发  如果客户不在线 可以保存到数据库 可以实现离线留言
                } else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //服务器端起到一个转发的作用
                    //需要遍历 管理线程的集合 把所有的线程的socket都得到 然后把message进行转发即可
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        //取出在线用户的id
                        String onLineUserId = iterator.next().toString();

                        if(!onLineUserId.equals(message.getSender())) { //排除群发消息的这个用户

                            //进行转发message
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);

                        }
                    }

                } else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //根据getterid 获取到对应的线程 将message对象转发
                    ServerConnectClientThread scct =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos =
                            new ObjectOutputStream(scct.getSocket().getOutputStream());
                    //转发
                    oos.writeObject(message);


                }
                else {
                    System.out.println("目前是未处理类型message");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
