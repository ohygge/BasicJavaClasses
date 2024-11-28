package com.a26Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo1 {
    public static void main(String[] args) throws IOException {
        //创建客户端的Socket对象
        Socket s = new Socket("192.168.2.5", 10000);
        //获取输出流 写数据
        OutputStream os = s.getOutputStream();
        os.write("i am back now".getBytes());

        //接收服务器反馈
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String data = new String(bytes, 0, len);
        System.out.println("客户端说："+data);
        //释放资源 os和is 是创建的，故只需释放s即可
        s.close();
    }
}
