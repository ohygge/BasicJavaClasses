package com.a25InetAddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendUDPDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象（DatagramSocket）
        //
        DatagramSocket ds = new DatagramSocket();
        //封装键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }
            byte[] bytes = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.2.5"), 12345);
            //调用发送方法
            ds.send(dp);
        }
            ds.close();
    }
}
