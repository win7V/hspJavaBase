package com.edu.outputstream_;



import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutStream_ {

    public static void main(String[] args) throws Exception{

        //序列化后 保存的文件格式 不是纯文本 而是按照他的方式保存
        String filepath = "D:\\.book\\test\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));

        //序列化数据到该文件中
        oos.writeInt(100);//int -> Integer (实现了Serializable)
        oos.writeBoolean(true);//bool -> Boolean
        oos.writeChar('a');
        oos.writeUTF("hhh");//String
        //保存一个dog对象
        oos.writeObject(new Dog("wangwang",10));


        oos.close();
        System.out.println("数据保存完毕");

    }
}
