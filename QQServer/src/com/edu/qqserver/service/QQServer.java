package com.edu.qqserver.service;

import com.edu.qqcommon.Message;
import com.edu.qqcommon.MessageType;
import com.edu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/*
这是服务端  在监听9999 等待客户端连接  并保持通信
 */
public class QQServer {
    private ServerSocket ss = null;
    //创建一个集合 存放多个用户 如果是这些用户登录 就认为是合法的
    //这里也可以使用ConcurrentHashMap 可以处理并发的集合 没有线程安全
    //HashMap  没有处理线程安全  因此在多线程的情况下是不安全的
    private static HashMap<String, User> validUsers = new HashMap<>();

    static {//在静态代码块初始化 validUsers
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("老大", new User("老大", "123456"));
        validUsers.put("老二", new User("老二", "123456"));
        validUsers.put("老三", new User("老三", "123456"));

    }

    //验证用户是否有效的方法
    private boolean checkUser(String userId, String pwd) {
        // 从 validUsers 中查找给定的 userId
        User user = validUsers.get(userId);
        if(user == null) { //说明userId没有存在validUsers的key中
            return false;
        }
        if(!user.getPasswd().equals(pwd)) {//userId正确 但是密码错误
            return false;
        }
        return true;

    }

    public QQServer() {

        try {
            System.out.println("服务端在9999端口监听...");
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();

            ss = new ServerSocket(9999);//端口可以写在配置文件

            while (true) { //当和某个客户端连接后 会继续监听 因此while
                Socket socket = ss.accept();//如果没有Client连接 会阻塞在这里
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();//读取客户端发送的User对象
                //创建一个Message对象  准备回复客户端
                //因为无论成功或者失败 都需要发送message 所以定义在外面
                Message message = new Message();
                //验证用户 方法
                if(checkUser(u.getUserId(), u.getPasswd())) {//验证成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复
                    oos.writeObject(message);
                    //创建一个线程 和Client保持联系 该线程需要持有socket对象
                    ServerConnectClientThread scct = new ServerConnectClientThread(socket, u.getUserId());
                    scct.start();
                    //把该线程对象放入到一个集合中，进行管理
                    ManageClientThreads.addClientThread(u.getUserId(), scct);

                } else {//登录失败
                    System.out.println("用户id = " + u.getUserId() + " 密码pwd = " + u.getPasswd() + "登录失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //登录失败  关闭socket
                    socket.close();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果Server推出了while 说明Server不再监听  因此关闭ServerSocket
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
