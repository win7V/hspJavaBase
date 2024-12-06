package com.edu.interface_;

public class Camera implements UsbInterface {

    @Override
    public void start() {
        System.out.println("Camera start");
    }

    @Override
    public void end() {
        System.out.println("Camera end");
    }
}