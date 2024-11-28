package com.a17BufferStream;

import java.io.*;

public class BufferStreamDemo {
    public static void main(String[] args) throws IOException {
        // 字节缓冲输出流 和 字节缓冲输出流
        //bufferOutput();

        // 字节缓冲输入流
        //bufferInput();
        long startTime = System.currentTimeMillis();
        // 复制视频
        // 基本字节流一次读取一个字节  total time ms:90285
        //copyVidio1();
        // 基本字节流一次读取一个字节数组
        //copyVidio2();
        // 字节缓冲流一次读写一个字节
        //copyVidio3();
        // 字节缓冲流一次读写一个字节数组
        //copyVidio4();
        long endTime = System.currentTimeMillis();
        System.out.println("total time ms:"+(endTime-startTime));
        System.out.println("---------------");
        //copyFolderDemo1();
        System.out.println("---------------");
        //copyFolderDemo2();
        System.out.println("---------------");

    }
    //复制多级文件夹到项目文件夹下
    private static void copyFolderDemo2() throws IOException {
        //创建数据源file对象 以及 目的地file对象
        File srcFile = new File("/Users/earth_1202/Downloads/Friday");
        File destFile = new File("BasicJavaClasses2020/");
        //该方法实现文件夹以及文件的复制
        copyFolder2(srcFile,destFile);

    }

    private static void copyFolder2(File srcFile, File destFile) throws IOException {
        if (srcFile.isDirectory()) {
            //如果是目录 则创建目的地一样的目录
            File newFolder = new File(destFile, srcFile.getName());
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }
            //获取数据源file下的文件数组
            File[] listFiles = srcFile.listFiles();
            //遍历该数组 得到每一个文件对象
            for (File f : listFiles) {
                copyFolder2(f,newFolder);
            }
        } else {
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile,newFile);
        }
    }

    // 复制单级文件夹到项目模块下（文件类型多样故用缓冲字节流）
    public static void copyFolderDemo1() throws IOException{
        // 创建源文件夹对象
        File srcFile = new File("/Users/earth_1202/Downloads/Fridays");
        String srcFileName = srcFile.getName();
        // 创建目的地文件夹对象
        File destFile = new File("BasicJavaClasses2020", srcFileName);
        if (!destFile.exists()) {
            destFile.mkdir();
        }
        // 遍历源文件夹文件 读取并写入
        File[] listFiles = srcFile.listFiles();
        for (File srcfile : listFiles) {
            String srcN = srcfile.getName();
            File destF = new File(destFile, srcN);
            // 读写复制文件
            copyFile(srcfile,destF);
        }

    }

    private static void copyFile(File srcfile, File destF) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcfile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destF));
        byte[] bytes = new byte[1024];
        int lens = 0;
        while ((lens = bis.read(bytes)) != -1) {
            bos.write(bytes,0,lens);
        }
        bis.close();
        bos.close();
    }

    // 缓冲字节流一次读取一个字节数组
    public static void copyVidio4() throws IOException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream("/Users/earth_1202/Downloads/Friday/video.mov"));
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("BasicJavaClasses2020/video.mov"));
        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys,0,len);
        }
        fos.close();
        fis.close();
    }

    // 缓冲字节流一次读取一个字节
    public static void copyVidio3() throws IOException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream("/Users/earth_1202/Downloads/Friday/video.mov"));
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("BasicJavaClasses2020/video.mov"));
        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        fos.close();
        fis.close();
    }

    // 基本字节流一次读取一个字节数组
    public static void copyVidio2() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/earth_1202/Downloads/Friday/video.mov");
        FileOutputStream fos = new FileOutputStream("BasicJavaClasses2020/video.mov");
        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys,0,len);
        }
        fos.close();
        fis.close();
    }

    // 基本字节流一次读取一个字节
    public static void copyVidio1() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/earth_1202/Downloads/Friday/video.mov");
        FileOutputStream fos = new FileOutputStream("BasicJavaClasses2020/video.mov");
        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        fos.close();
        fis.close();
    }


    // 字节缓冲输出流
    public static void bufferOutput() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("BasicJavaClasses2020/marvel.txt"));
        bos.write("hello\n".getBytes());
        bos.write("world\n".getBytes());
        bos.close();
    }

    // 字节缓冲输入流
    public static void bufferInput() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("BasicJavaClasses2020/marvel.txt"));
        /*byte[] bys= new byte[1024];
        int len ;
        while ((len = bis.read(bys)) != -1) {
            System.out.print(new String(bys,0,len));
        }*/
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }
        bis.close();
    }
}
