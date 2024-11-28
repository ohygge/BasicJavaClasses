package com.a9CollectionDemo;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetCaiPiaoDemo {
    public static void main(String[] args) {
        System.out.println("自然排序-----------机打双色球彩票");
        Set<Integer> numSet = new TreeSet<Integer>();
        Random r = new Random();
        while (numSet.size()<7){
            int luckNum = r.nextInt(31) + 1;
            numSet.add(luckNum);
        }

        for (Integer i:numSet
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