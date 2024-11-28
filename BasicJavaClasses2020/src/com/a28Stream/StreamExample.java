package com.a28Stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        //体验Stream流
        ArrayList<String> babyList = new ArrayList<>();
        babyList.add("tank");
        babyList.add("trick");
        babyList.add("bang");
        babyList.add("gun");
        babyList.add("tiny");
        ArrayList<String> tList = new ArrayList<>();
        for (String s : babyList) {
            if (s.startsWith("t")) {
                tList.add(s);
            }
        }
        ArrayList<String> threeList = new ArrayList<>();
        for (String s : tList) {
            if (s.length() == 4) {
                threeList.add(s);
            }
        }
        for (String ss : threeList) {
            System.out.println(ss);
        }
        System.out.println("----------");
        //Stream 流改进
        //Stream流的常见中间操作方法
        //Stream<T> filter(Predicate pre) : 对于流中的数据进行过滤;Predicate接口中的test方法返回布尔值
        babyList.stream().filter(s -> s.startsWith("t")).filter(s -> s.length() == 4).forEach(s -> System.out.println(s));
        babyList.stream().filter(s -> s.startsWith("t")).filter(s -> s.length() == 4).forEach(System.out::println);
        //Collection体系的集合可以使用默认方法stream() 生成流
        //Map体系的集合间接生成流
        //数组可以通过Stream接口的静态方法of(T... values)生成流
        ArrayList<String> strList = new ArrayList<>();
        Stream<String> strListStream = strList.stream();
        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();
        Map<String, Integer> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valuesStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();
        Stream<Integer> integerStream = Stream.of(54, 32, 22, 1);
        //常见中间操作方法
        //Stream<T> limit(long size) : 返回此流中的元素组成的流，截取前指定参数个数的数据
        //Stream<T> skip(long n) : 跳过指定参数个数的数据，返回由该流的剩余元素组成的流
        System.out.println("----limit--skip--");
        babyList.stream().skip(2).limit(2).forEach(System.out::println);
        //Stream<T> concat(S a,S b) ：合并;Stream<T> distinct() ：输出不相同数据


    }
}
