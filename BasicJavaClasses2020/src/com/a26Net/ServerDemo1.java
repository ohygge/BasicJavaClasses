package com.a26Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        //创建服务器端socket
        ServerSocket serverSocket = new ServerSocket(10000);
        //监听
        Socket acceptSocket = serverSocket.accept();

        //获取输入流，读数据
        InputStream is = acceptSocket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String data = new String(bytes, 0, len);
        System.out.println("数据已经收到："+data);
        //给出反馈
        OutputStream os = acceptSocket.getOutputStream();
        os.write("i know ~".getBytes());
        //释放资源
        serverSocket.close();
    }
}
