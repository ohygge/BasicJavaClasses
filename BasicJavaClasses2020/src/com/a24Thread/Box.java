package com.a24Thread;

public class Box {
    //定义一个成员变量，表示第x瓶牛奶
    private int milk;
    //定义一个成员变量，表示奶箱的状态
    private boolean state = false;

    //提供存储牛奶和获取牛奶的操作
    public synchronized void put(int milk){
        //如果有牛奶，等待消费
        if (state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有牛奶就生产牛奶
        this.milk=milk;
        System.out.println("put No." + this.milk + "milk into box");
        //生产完毕之后，修改奶箱状态
        state = true;
        notifyAll();
    }

    public synchronized void get(){
        //如果没有牛奶，等待生产
        if (!state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果有牛奶，就消费牛奶
        System.out.println("user get No." + this.milk + "milk");
        //消费完毕后，修改奶箱状态
        state = false;
        //唤醒其他
        notifyAll();
    }
}
