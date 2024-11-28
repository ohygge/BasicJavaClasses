package com.a21BufferedStream;

import java.io.*;
import java.util.*;

public class BufferedReader_WriteDemo {
    private Student stu;

    public static void main(String[] args) throws IOException {
        // 字符缓冲流 的读写
        BufferedWriter bw = new BufferedWriter(new FileWriter("BasicJavaClasses2020/marvel.txt"));
        bw.write("hello\n");
        bw.write("java\n");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("BasicJavaClasses2020/marvel.txt"));
        // 一次读取一个字符数据 或者 一次读取一个字符数组
//        char[] chs = new char[1024];
//        int len;
//        while ((len = br.read(chs)) != -1) {
//            System.out.println(new String(chs,0,len));
//        }
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        System.out.println("--------------");
        arrayListToTxt();
        System.out.println("--------------");
        txtToArrayList();
        System.out.println("--------------");
        callName();
        System.out.println("--------------");
        //StudentScoreToTxt();
        System.out.println("--------------");
        //字符打印流 复制文件
        copyFileByPrintWriter();
        System.out.println("--------------");


    }

    private static void copyFileByPrintWriter() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("BasicJavaClasses2020/marvel.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("BasicJavaClasses2020/marvel2.txt"), true);
        String line;
        while ((line=br.readLine())!=null){
            pw.println(line);
        }
        pw.close();
        br.close();
    }

    // 集合数据写入文件：学生姓名，语数英成绩集合按总分高低写入文件，一行一学生
    public static void StudentScoreToTxt() throws IOException {
        // 创建TreeSet集合
        TreeSet<Student> studentTreeSet = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s2.getSum() - s1.getSum();
                int num1 = num == 0 ? s2.getChineseNum() - s1.getChineseNum() : num;
                int num2 = num1 == 0 ? s2.getMathNum() - s1.getMathNum() : num1;
                int num3 = num2 == 0 ? s2.getName().compareTo(s1.getName()) : num2;
                return num3;
            }
        });
        // 输入3个学生成绩
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input " + (i + 1) + " stu info :");

            System.out.println("name:");
            String name = scanner.nextLine();
            System.out.println("chineseNum:");

            int chineseNum = scanner.nextInt();
            System.out.println("mathNum:");
            int mathNum = scanner.nextInt();
            System.out.println("EngNum:");
            int engNum = scanner.nextInt();

            Student stu = new Student(name, chineseNum, mathNum, engNum);
            studentTreeSet.add(stu);

        }
        // 集合写入到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("BasicJavaClasses2020/marvel.txt"));
        for (Student s : studentTreeSet) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName() + "," + s.getChineseNum() + "," + s.getMathNum() + "," + s.getEnglishNum() + "," + s.getSum());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();

        }
        bw.close();
    }

    // 随机点名器 把文件里的姓名随机点名到控制台
    public static void callName() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("BasicJavaClasses2020/marvel.txt"));
        ArrayList<String> arrStr = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            arrStr.add(str);

        }
        br.close();
        Random r = new Random();
        int num = r.nextInt(arrStr.size());
        String name = arrStr.get(num);
        System.out.println("name is :" + name);

    }

    // 文件数据存储到集合
    public static void txtToArrayList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("BasicJavaClasses2020/marvel.txt"));
        ArrayList<String> arrayStr = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            arrayStr.add(str);

        }
        br.close();
        for (String s : arrayStr) {

            System.out.println(s);
        }
    }

    // 集合字符串数据写入文件
    public static void arrayListToTxt() throws IOException {
        // 创建 集合对象
        ArrayList<String> arrayStr = new ArrayList<>();
        // 添加字符串元素
        arrayStr.add("tell");
        arrayStr.add("you");
        // 创建字符缓冲流输出对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("BasicJavaClasses2020/marvel.txt"));

        // 遍历集合 调用缓冲输出流对象的方法
        for (String s : arrayStr) {
            bw.write(s);
            bw.newLine();
        }
        // 释放资源
        bw.close();

    }


}
