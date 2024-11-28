package com.a25InetAddress;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo {
    //TCP发送的数据步骤
    //1、创建客户端Socket对象 2、获取输出流，写数据 3、释放资源
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.2.5"), 4321);
        OutputStream os = socket.getOutputStream();
        os.write("I am back".getBytes());
        os.close();
        socket.close();
    }

}
