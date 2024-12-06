package com.edu.qqclient.service;

import com.edu.qqcommon.Message;
import com.edu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

//该类/对象 提供和消息相关的服务方法
public class MessageClientService {

    public void sendMessageToAll(String content, String senderId) {
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(senderId);
        message.setContent(content);
        message.setSendtime(new Date().toString());
        System.out.println(senderId + "对大家说: " + content);

        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //消息内容  发送者id  接收者id
    public void sendMessageToOne(String content, String senderId, String getterId) {
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);//普通的聊天消息
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendtime(new Date().toString());//发送时间设置到 message对象
        System.out.println(senderId + "对" + getterId + "说" + content);
        //发送给服务端

        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
