package com.a16FileInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 读取文件数据
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("MCUserManager/marvel.txt");
        // 调用字节输入流对象的读取方法 read() 按照一个字节读取
        int by = 0;
        while ((by = fis.read()) != -1) {
            System.out.print((char)by);
        }
        // 释放资源
        fis.close();

        System.out.println("---------------");
        // 复制文件
        //copyFile();
        // 按照一个字节数组读取
        //readByte();
        //copyPhoto();

    }

    // 复制磁盘文件到模块目录下
    public static void copyFile() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/earth_1202/Downloads/Friday/666/bb.txt");
        FileOutputStream fos = new FileOutputStream("MCUserManager/bb.txt");

        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        fis.close();
        fos.close();
    }

    // int read(byte[] b) ： 从该输入流最多读取b.length个字节到一个字节数组
    public static void readByte() throws IOException {
        FileInputStream fis = new FileInputStream("MCUserManager/marvel.txt");

        byte[] by = new byte[1024];
        int len;
        while ((len = fis.read(by)) != -1) {
            System.out.println("len=="+len);
            System.out.print(new String(by,0,len));
        }
        fis.close();
    }

    // 复制图片到模块目录下
    public static void copyPhoto() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/earth_1202/Downloads/Friday/earth.jpg");
        FileOutputStream fos = new FileOutputStream("MCUserManager/earth.jpg");

        byte[] by = new byte[1024];
        int len;
        while ((len = fis.read(by)) != -1) {
            System.out.println("len=="+len);
            fos.write(by,0,len);
        }
        fis.close();
        fos.close();
    }
}
