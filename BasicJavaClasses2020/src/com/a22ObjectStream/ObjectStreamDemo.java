package com.a22ObjectStream;

import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //对象序列化流 ObjectOutputStream

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MCUserManager/marvel2.txt"));
        Student s1 = new Student("jack", 98, 88, 89);
        oos.writeObject(s1);
        oos.close();

        System.out.println("-----------");

        //对象反序列化流读取 ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MCUserManager/marvel2.txt"));
        Object obj = ois.readObject();
        Student s = (Student) obj;
        System.out.println(s.getName()+s.getChineseNum());

        //假如修改了student对象的类文件，读取数据会不会出问题呢？ 会。并抛出InvalidClassException异常
        //如何解决？ 给类文件中增加变量private static final long serialVserionUID = 42L;
        //如果类中某个成员变量不想被序列化 则使用transient修饰

    }
}
