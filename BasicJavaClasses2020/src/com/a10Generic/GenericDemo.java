package com.a10Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        // 泛型 demo
        Collection<String> cs = new ArrayList<String>();
        cs.add("it");
        cs.add("is");
        cs.add("generic");

        Iterator<String> it = cs.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        System.out.println("--------各自模版处理");
        Student s = new Student();
        s.setName("tom");
        System.out.println(s.getName());

        Teacher t = new Teacher();
        t.setAge(112);
        System.out.println(t.getAge());

        System.out.println("---------用泛型类处理");

        GenericX<Integer> g1 = new GenericX<Integer>();
        g1.setT(12);
        System.out.println(g1.getT());

        GenericX<Boolean> g3 = new GenericX<Boolean>();
        g3.setT(true);
        System.out.println(g3.getT());

        System.out.println("---------泛型方法处理");
        GenericM gm = new GenericM();
        gm.show("red");
        gm.show(23);
        gm.show(true);

        System.out.println("---------泛型接口实现");
        GenericI<String> gis = new GenericImpl<String>();
        gis.show("roman");

        System.out.println("---------类型通配符<?>的上下限");
        // Object Number Integer
        List<?> list1 = new ArrayList<Object>();
        List<? extends Number> list2 = new ArrayList<Integer>();
        List<? super Number> list3 = new ArrayList<Object>();

    }

}
/*
* 泛型的好处
*  把运行时的问题提前到了编译时
*  避免了强制转换
* */