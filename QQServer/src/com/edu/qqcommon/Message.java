package com.edu.qqcommon;

import java.io.Serializable;

/*
表示客户端和服务端通信时的消息对象
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sender;
    private String getter;
    private String content;//消息内容
    private String sendtime;//发送时间   需要序列化 用String
    private String mesType;//消息类型  可以在接口定义消息类型

    //进行扩展 和文件相关的成员
    private byte[]  fileBytes;
    private int fileLen = 0;
    private String dest;//将文件传输到哪里
    private String src;//传输文件的源路径

//    public Message(String sender, String getter, String content, String sendtime, String mesType) {
//        this.sender = sender;
//        this.getter = getter;
//        this.content = content;
//        this.sendtime = sendtime;
//        this.mesType = mesType;
//    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
