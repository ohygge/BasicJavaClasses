package com.a26Net;

import java.io.*;
import java.net.Socket;

public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象

        Socket socket = new Socket("192.168.2.5", 10001);
        //键盘录入，知道输入的数据是886结束
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //将文本文件读取发送至服务器端
        //BufferedReader br = new BufferedReader(new FileReader("MCUserManager/marvel.txt"));


        //封装输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line=br.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.close();
        }
        socket.shutdownOutput();
        //自定义结束标记
        /*bw.write("886");
        bw.newLine();
        bw.flush();*/
        //接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data = brClient.readLine();
        System.out.println("服务器给的反馈是：" + data);

        //释放资源
        socket.close();
    }
}
