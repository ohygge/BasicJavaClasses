package com.a9CollectionDemo;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        // 创建collection集合对象 单例集合的顶层接口
        Collection<String> c = new ArrayList<String>();
        c.add("hello");
        c.add("world");
        c.add("world");
        System.out.println(c.remove("world"));
        System.out.println(c.contains("world"));
        System.out.println(c);

        System.out.println("-----------");
        // 迭代器 iterator 先得到iterator对象 ;next(); hasNext();
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
            /*
            // ConcurrentModificationException 并发修改异常
            // 迭代器遍历的过程中，通过集合修改了集合元素的长度
            // 造成迭代器获取元素中判断预期修改值和实际修改值的不一致
            if("world".equals(s)){
                c.add("hi");
            }*/
        }

        System.out.println("-----------");
        Collection<Student> studentArrayList = new ArrayList<>();
        Student s1 = new Student("tom", 12);
        Student s2 = new Student("tommy", 32);
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        Iterator<Student> its = studentArrayList.iterator();
        while (its.hasNext()) {
            Student student = its.next();
            System.out.println(student.getName() + "," + student.getAge());
        }

        System.out.println("-----------");
        // 创建List集合对象 有序，可重复
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("world");
        System.out.println(list.remove("world"));
        System.out.println(list.contains("world"));
        System.out.println(list);

        System.out.println("-----------");
        // 创建Set集合对象 无序，不可重复
        Set<String> ss = new HashSet<>();
        ss.add("rose");
        ss.add("88");
        ss.add("world");
        ss.add("world");

        for (String s : ss
        ) {
            System.out.println("Set==" + s);
        }

        System.out.println("-----------");
        // 使用HashSet存储相同的student对象
        HashSet<Student> stu = new HashSet<>();
        Student st1 = new Student("rose", 12);
        Student st2 = new Student("rise", 13);
        Student st3 = new Student("wong", 32);
        Student st4 = new Student("rose", 12);
        stu.add(st1);
        stu.add(st2);
        stu.add(st3);
        stu.add(st4); // 重写equals(),hashCode()
        for (Student s : stu
        ) {
            System.out.println(s.getName() + "." + s.getAge());
        }
        System.out.println("-----------");
        // 使用TreeSet存储对象
        TreeSet<Integer> tset = new TreeSet<Integer>();
        tset.add(10);
        tset.add(30);
        tset.add(20);

        tset.add(30);
        for (Integer i: tset
             ) {
            System.out.println(i);
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