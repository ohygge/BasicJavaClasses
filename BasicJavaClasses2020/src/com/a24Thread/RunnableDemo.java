package com.a24Thread;

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        //创建Thread对象，将MyRunnable对象作为参数传递
        Thread t1 = new Thread(mr,"t1");
        Thread t2 = new Thread(mr,"t2");
        Thread t3 = new Thread(mr,"t3");
        Thread t4 = new Thread(mr,"t4");
        Thread t5 = new Thread(mr,"t5");
        Thread t6 = new Thread(mr,"t6");
        //同一个mr资源，让多个线程去使用
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
