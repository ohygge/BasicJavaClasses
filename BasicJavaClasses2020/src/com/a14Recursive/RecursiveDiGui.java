package com.a14Recursive;

import java.io.File;

public class RecursiveDiGui {
    public static void main(String[] args) {
        // 递归算法
        // 计算第n个月有多少兔子对数 1,1,2,3,5,8...
        // f(n) 第n个月的兔子对数
        System.out.println(f(4));
        System.out.println(f(20));

        // 使用递归方法 求5的阶乘
        // 5!=5*4*3*2*1=5*4!
        // n*jiecheng(n-1)
        int result = jiecheng(5);
        System.out.println("jiecheng==="+result);
        System.out.println("--------------");
        // 递归遍历文件夹目录获取其中所有文件
        File file3 = new File("/Users/earth_1202/Downloads/Friday");
        getFilePath(file3);

    }
    // 递归方法兔子对数
    public static int f(int n){
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return f(n-1)+f(n-2);
        }
    }
    // 递归阶乘
    public static int jiecheng(int n){
        if (n == 1) {
            return 1;
        } else {
            return n*jiecheng(n-1);
        }
    }
    // 递归获取文件
    public static void getFilePath(File f){
        File[] filesList = f.listFiles();
        if (filesList != null) {
            for (File file : filesList) {
                if (file.isDirectory()) {
                    getFilePath(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }

    }
}
