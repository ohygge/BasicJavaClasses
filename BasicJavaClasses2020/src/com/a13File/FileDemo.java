package com.a13File;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File f1 = new File("/Users/earth_1202/Downloads/Friday");
        System.out.println(f1);
        System.out.println("---------");
        File f2 = new File("/Users/earth_1202/Downloads/Friday");
        System.out.println(f2.mkdir());
        System.out.println("---------");
        File f3 = new File("/Users/earth_1202/Downloads/Friday/fa.txt");
        System.out.println(f3.createNewFile());
        System.out.println("---------");
        File f4 = new File("/Users/earth_1202/Downloads/Fridays/Noon");
        System.out.println(f4.mkdirs());
        System.out.println("---------");
        File file1 = new File("MCUserManager/marvel.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.getAbsolutePath());;
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println("-----返回此抽象路径名表示的目录文件和目录名称字符串----");
        File file2 = new File("/Users/earth_1202/Downloads/Friday");
        String[] strArr = file2.list(); // 返回此抽象路径名表示的目录文件和目录名称字符串
        for (String str : strArr) {
            System.out.println(str);
        }
        System.out.println(strArr.toString());
        System.out.println("---------");
        File file3 = new File("/Users/earth_1202/Downloads/Friday");
        File[] filesArr = file3.listFiles();
        for (File f : filesArr) {
            //System.out.println(f);
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }


        // 当前模块下创建myFile目录，在其目录下创建it01.txt文件
        File mf = new File("MCUserManager/myFile");
        System.out.println(mf.mkdir());
        File mf2 = new File("MCUserManager/myFile/it01.txt");
        System.out.println(mf2.createNewFile());

        System.out.println(mf2.delete());
        System.out.println(mf.delete());

    }
}
