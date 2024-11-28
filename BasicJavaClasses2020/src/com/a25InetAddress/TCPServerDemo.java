package com.a25InetAddress;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
    public static void main(String[] args) throws IOException {
        //TCP接收数据的步骤
        //创建服务器端Socket 获取输入流读数据 释放资源
        ServerSocket serverSocket = new ServerSocket(4321);
        Socket acceptSoc = serverSocket.accept();
        InputStream is = acceptSoc.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys,0,len);
        System.out.print("TCP接收数据:"+data);
        acceptSoc.close();
        serverSocket.close();

    }
}
