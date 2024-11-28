package com.a18Encode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class UniCodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 编码和解码 GBK系列 UTF-8
        String s = "中国";
        byte[] by = s.getBytes();// getBytes()方法默认编码为UTF-8
        System.out.println("UTF-8:"+Arrays.toString(by));

        byte[] by1 = s.getBytes("GBK");
        System.out.println("GBK:"+Arrays.toString(by1));

        // 解码
        String ss = new String(by); // 默认为UTF-8
        System.out.println("UTF-8解码："+ss);

        String sss = new String(by1,"GBK");
        System.out.println("GBK解码："+sss);
    }
}
