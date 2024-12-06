package com.edu.qqserver.service;


import com.edu.qqcommon.Message;
import com.edu.qqcommon.MessageType;
import com.edu.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SendNewsToAllService implements Runnable{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {

        //为了可以多次推送新闻 使用while
        while (true) {
            System.out.println("请输入服务器要推送的新闻/消息(输入exit表示退出推送服务线程)");
            String news = Utility.readString(100);
            //构建一个消息
            if("exit".equals(news)) {
                break;
            }
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setSendtime(new Date().toString());
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);

            System.out.println("服务器推送消息给所有人说: " + news);

            //遍历当前所有的用心线程  得到socket 并发送message

            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onLineUserId = iterator.next().toString();

                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
