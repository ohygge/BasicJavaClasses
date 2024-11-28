package com.a24Thread;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("all");
        MyThread mt2 = new MyThread("rose");
        MyThread mt3 = new MyThread("tom");

        System.out.println(mt1.getPriority());
        System.out.println(mt2.getPriority());
        System.out.println(mt3.getPriority());
        //设置优先级
//        mt1.setPriority(1);
//        mt2.setPriority(5);
//        mt3.setPriority(10);
        //sleep() 让run()每过一段时间执行一次，但三人可随机抢占执行
        //join() 让使用该方法的对象执行完该对象自己的任务后才可继续往下执行其他对象的任务
        //setDaemon(true) 设置守护线程
        mt1.setDaemon(true);
        mt2.setDaemon(true);
        mt3.setDaemon(true);

        mt1.start();
//        try {
//            mt1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        mt2.start();
        mt3.start();
        //设置主线程 并设置守护线程（主线程结束后，守护线程也应紧跟结束 start()前设置
        System.out.println(Thread.currentThread().getName());
        for (int i = 990; i <1000 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
