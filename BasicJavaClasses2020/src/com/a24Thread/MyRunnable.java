package com.a24Thread;

public class MyRunnable implements Runnable {
    private int tickets = 200;
    private Object obj = new Object();
    private int x = 0;
    @Override
    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName()+":"+i);
//        }
        while (true) {
            if (x % 2 == 0) {
                synchronized (this) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张票");
                        tickets--;
                    }
                }
            }else {
//                synchronized (obj) {
//                    if (tickets > 0) {
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张票");
//                        tickets--;
//                    }
//                }
                sellTickets();
            }
            x++;
        }
    }

    //synchronized同步方法时，（方法内部有一个对象可以代表本类的）就是this
    private synchronized void sellTickets() {
        //synchronized (obj) {
            if (tickets > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张票");
                tickets--;
            }
        //}

    }
}
