package com.a24Thread;

public class Producer implements Runnable{
    private Box b;
    public Producer(Box b){
        this.b=b;
    }
    public void run(){
        for (int i = 1; i < 5; i++) {
            b.put(i);
        }
    }
}
