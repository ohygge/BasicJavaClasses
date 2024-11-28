package com.a9CollectionDemo;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        System.out.println("自然排序-----------创建集合采用无参构造方法");
        TreeSet<Student> stu = new TreeSet<Student>();
        Student st1 = new Student("rose", 12);
        Student st2 = new Student("rise", 83);
        Student st3 = new Student("wong", 32);
        Student st4 = new Student("rose", 12);
        stu.add(st1);
        stu.add(st2);
        stu.add(st3);
        //stu.add(st4);
        for (Student s : stu
        ) {
            System.out.println(s.getName() + "." + s.getAge());
        }


        System.out.println("比较器排序------------创建集合采用带参构造方法");
        // 比较器comparator排序
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s1.getAge() - s2.getAge();
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });

        Student st11 = new Student("tom", 2);
        Student st12 = new Student("jack", 88);
        Student st13 = new Student("jam", 43);
        Student st14 = new Student("tom", 2);
        ts.add(st11);
        ts.add(st12);
        ts.add(st13);
        ts.add(st14);
        for (Student s : ts
        ) {
            System.out.println(s.getName() + "." + s.getAge());
        }

        System.out.println("--------按成绩降序显示Robot的成绩");
        // 按成绩降序显示Robot的成绩 TreeSet带参构造比较器
        TreeSet<Robot> tr = new TreeSet<Robot>(new Comparator<Robot>() {
            @Override
            public int compare(Robot r1, Robot r2) {
                int num = r2.getSum() - r1.getSum();
                int num1 = num == 0 ? r2.getChinese() - r1.getChinese() : num;
                int num2 = num1 == 0 ? r2.getName().compareTo(r1.getName()) : num1;

                return num2;
            }
        });

        Robot tr11 = new Robot("tom", 2,4);
        Robot tr12 = new Robot("jack", 88,55);
        Robot tr13 = new Robot("jam", 43,32);
        Robot tr14 = new Robot("tom", 2,7);
        tr.add(tr11);
        tr.add(tr12);
        tr.add(tr13);
        tr.add(tr14);
        for (Robot s : tr
        ) {
            System.out.println(s.getName() + "." + s.getChinese()+","+s.getMath()+","+s.getSum());
        }
    }

}
// 集合：Collection单列；Map双列
// Collection：List可重复；Set不可重复
// Map：HashMap
// List：ArrayList;LinkedList
// Set：HashSet;TreeSet
/*
 * HashSet集合特点
 * 底层数据结构是哈希表；不保证存储和取出的元素顺序一致；
 * 没有带索引的方法，即不能使用普通for循环遍历；不含重复元素
 * HashSet集合存储元素：要保证元素唯一性，需重写hashCode()和equals()
 * */

/*
 * TreeSet集合特点
 * 元素有序，有序排序取决于构造方法；TreeSet() or TreeSet(Comparator c)
 * 没有带索引的方法，所以不能用普通for循环遍历；
 * 属于Set集合，即元素不重复
 * */