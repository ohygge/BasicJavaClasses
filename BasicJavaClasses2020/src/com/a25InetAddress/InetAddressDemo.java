package com.a25InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        //InetAddress 表示Internet协议（IP）地址
        InetAddress address = InetAddress.getByName("192.168.2.5");
        String hostName = address.getHostName();
        String IP = address.getHostAddress();
        System.out.println("hostName&IP:"+hostName+IP);

    }

}
