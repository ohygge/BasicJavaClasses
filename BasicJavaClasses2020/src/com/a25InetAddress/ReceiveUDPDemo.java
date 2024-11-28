package com.a25InetAddress;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveUDPDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端的Socket对象（DatagramSocket）
        DatagramSocket ds = new DatagramSocket(12345);
        while (true) {
            //创建一个数据包，用于接收数据
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            byte[] data = dp.getData();
            //解析
            System.out.println("data is : "+new String(dp.getData(),0,dp.getLength()));
        }
    }
}



