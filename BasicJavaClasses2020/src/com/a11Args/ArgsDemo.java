package com.a11Args;

import java.util.Arrays;
import java.util.List;

public class ArgsDemo {
    public static void main(String[] args) {
        System.out.println(sum(2,3));
        System.out.println(sum(2,3,4));
        System.out.println(sum(2,3,4,5));

        // 可变参数的使用 List.of方法是Java9引入
        // <T> List<T> asList(T... a) 返回有指定数组支持的固定大小的列表 返回集合不能增删，可修改
        // <E> List<E> of(E... elements) 返回包含任意数量元素的不可变列表 返回集合不能增删改
        // <E> Set<E> of(E... e) 返回一个包含任意数量元素的不可变集合 元素不能重复，不能增删且无修改 set无索引


        List<String> list1 = Arrays.asList("1", "2", "3");
//        list1.add("11");// UnsupportedOperationException
//        list1.remove("1");// UnsupportedOperationException
        list1.set(1, "5");
        System.out.println(list1);

//        List<String> ls = List.of("23","33","43","33");//List集合允许有重复元素
//        System.out.println(ls);

    }

    public static int sum(int... a){
        int sum = 0;
        for(int i : a){
            sum += i;
        }
        return sum;
    }


}

/*
* 多可变参数 int... a 代表数组
* 若 多参数+多可变参数 应把多可变参数置于最后(int a ,int... b)
* */