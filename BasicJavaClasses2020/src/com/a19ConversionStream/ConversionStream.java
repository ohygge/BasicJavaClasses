package com.a19ConversionStream;

import java.io.*;

public class ConversionStream {
    public static void main(String[] args) throws IOException {
        // 转换流构造方法 默认编码 和 指定编码
        // 字符流到字节流的桥梁 使用指定编码将写入的"字符"编码为"字节"
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("MCUserManager/marvel.txt"), "UTF-8");
        osw.write("中文");
        // 写数据方式1：写一个字符
        //osw.write(95);
        //osw.flush(); // 刷新流
        // 写数据方式2：写一个字符数组
        //char[] chs = {'a','b','c','d','e'};
        //osw.write(chs);
        // 写数据方式3：写入字符数组的一部分
        //osw.write(chs,0,chs.length);
        //osw.write(chs,1,4);
        // 写数据方式4：写一个字符串
        //osw.write("中文");
        // 写数据方式5：写一个字符串的一部分
        //osw.write("中文",0,"中文".length());

        osw.close();

        // 一次读取一个字符数据
        InputStreamReader isr = new InputStreamReader(new FileInputStream("MCUserManager/marvel.txt"), "UTF-8");
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);

        }
        isr.close();
    }



}
