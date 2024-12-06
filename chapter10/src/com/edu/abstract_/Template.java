package com.edu.abstract_;

public abstract class  Template{
    public abstract void job();
    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}
