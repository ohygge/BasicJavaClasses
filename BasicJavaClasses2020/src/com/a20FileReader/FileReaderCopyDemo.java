package com.a20FileReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderCopyDemo {
    public static void main(String[] args) throws IOException {
        // 用字符流复制文件
        // 数据源 --读数据 --Reader --InputStreamReader -- FileReader
        // 目的地 --写数据 --Writer --OutputStreamWriter -- FileWrite
        FileReader fr = new FileReader("MCUserManager/marvel.txt");
        FileWriter fw = new FileWriter("MCUserManager/copy.txt");

        // 字符数组
        char[] chs = new char[1024];
        int len;
        while ((len = fr.read(chs)) != -1) {
            fw.write(chs,0,len);
        }

        fr.close();
        fw.close();
    }

}
