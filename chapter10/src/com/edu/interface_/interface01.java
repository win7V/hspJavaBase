package com.edu.interface_;

public class interface01 {
    public static void main(String[] args) {
        Camera camera = new Camera();
        Phone phone = new Phone();

        Computer computer = new Computer();

        computer.work(phone);//把phone 接入到 computer

        computer.work(camera);
    }
}
