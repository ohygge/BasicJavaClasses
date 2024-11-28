package com.a15FileOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {

        // m1 将指定的字节写入此文件输出流
        //write1();
        // m2 将指定的字节写入此文件输出流
        //write2();
        // m3 将指定的字节写入此文件输出流
        //write3();
        // m4 将指定的字节写入此文件输出流
        write1();

    }

    // 1 将指定的字节写入此文件输出流
    public static void write1() throws IOException {
        // 创建字节输出流对象 调用系统功能创建文件a；创建字节输出流对象b；让b指向a
        FileOutputStream fos = new FileOutputStream("MCUserManager/marvel.txt");
        // 将指定的字节写入此文件输出流
        char a = 'A';
        a = '\u2034'; //char类型的字符4的十六进制值
        //fos.write(57);
        fos.write(a); //char类型的字符常量A
        fos.write(65);//char类型的字符常量A的编码值65，即指定的字节
        fos.close();
    }

    // 2 将指定的字节写入此文件输出流
    public static void write2() throws IOException {
        // 创建字节输出流对象 调用系统功能创建文件a；创建字节输出流对象b；让b指向a
        FileOutputStream fos = new FileOutputStream("MCUserManager/marvel.txt");
        byte[] bys = {97,98,99,100,101};
        // 将指定的字节写入此文件输出流
        fos.write(bys);
        fos.close();
    }
    // 3 将指定的字节写入此文件输出流
    public static void write3() throws IOException {
        // 创建字节输出流对象 调用系统功能创建文件a；创建字节输出流对象b；让b指向a
        FileOutputStream fos = new FileOutputStream("MCUserManager/marvel.txt");
        byte[] bys = "abcde".getBytes();
        // 将指定的字节写入此文件输出流
        fos.write(bys);
        fos.close();
    }
    // 4 将指定的字节写入此文件输出流
    public static void write4() throws IOException {
        // 创建字节输出流对象 调用系统功能创建文件a；创建字节输出流对象b；让b指向a
        FileOutputStream fos = new FileOutputStream("MCUserManager/marvel.txt");
        byte[] bys = {97,98,99,100,101};
        // 将指定的字节写入此文件输出流
        fos.write(bys,1,3);
        fos.close();
    }
    // 5 将指定的字节写入此文件输出流 异常捕获
    public static void write5() {
        // 创建字节输出流对象 调用系统功能创建文件a；创建字节输出流对象b；让b指向a
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("MCUserManager/marvel.txt");
            byte[] bys = {97,98,99,100,101};
            // 将指定的字节写入此文件输出流
            fos.write(bys,1,3);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
