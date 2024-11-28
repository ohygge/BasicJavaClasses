package com.a26Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        //创建服务器Socket
        ServerSocket serverSocket = new ServerSocket(10001);

        //监听
        Socket acceptSocket = serverSocket.accept();

        //该步骤实现多线程上传文件
        /*while (true){
            //监听客户端，返回一个对应的socket对象
            Socket s = serverSocket.accept();
            new Thread(new ServerThread(s)).start();
        }*/


        //获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        //写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("MCUserManager/serverDemo2.txt"));
        String txt;
        while ((txt=br.readLine()) != null) {
           /* if ("886".equals(txt)) { //
                break;
            }*/
            bw.write(txt);
            bw.newLine();
            bw.flush();
        }

        //服务器端接收文件成功后，给出反馈
        BufferedWriter bwFeedBack = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
        bwFeedBack.write("文件上传成功");
        bwFeedBack.newLine();
        bwFeedBack.flush();


        //释放资源
        bw.close();
        acceptSocket.close();
    }
}
