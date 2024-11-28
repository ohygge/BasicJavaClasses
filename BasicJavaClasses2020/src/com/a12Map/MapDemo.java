package com.a12Map;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        // Map 集合 Map<K,V>
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("001", "tom");
        map1.put("002", "jack");
        map1.put("003", "boy");
        map1.put("003", "man");
        System.out.println(map1);

        // V remove(Object key) 删除
        System.out.println("map1.remove(\"001\")" + map1.remove("001"));
        System.out.println("map1.remove(\"009\")" + map1.remove("009"));

        System.out.println(map1.containsKey("002"));
        System.out.println(map1.containsValue("man"));
        System.out.println(map1.isEmpty());
        System.out.println(map1.size());

        System.out.println("----------------");
        System.out.println(map1.get("002"));

        Set<String> set1 = map1.keySet();
        for (String key : set1) {
            System.out.println("key=" + key);
        }
        //
        Collection<String> values = map1.values();
        for (String v : values) {
            System.out.println("v=" + v);
        }

        // Map集合的遍历1
        Set<String> keySet1 = map1.keySet();
        for (String key : keySet1) {
            String value = map1.get(key);
            System.out.println(key+","+value);
        }

        // Map集合的遍历2
        Set<Map.Entry<String, String>> entries = map1.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("2dn="+key+","+value);
        }

        System.out.println("--------HashMap集合存储--------key, Student键值对");

        HashMap<String, Student> mapStu = new HashMap<String, Student>();
        Student st01 = new Student("girl",12);
        Student st02 = new Student("boy",32);
        mapStu.put("1201", st01);
        mapStu.put("1202", st02);
        Set<Map.Entry<String, Student>> entries1 = mapStu.entrySet();
        for (Map.Entry<String, Student> keyStu : entries1) {
            String key = keyStu.getKey();
            Student stu = keyStu.getValue();
            System.out.println("Map.Entry<>=="+key+","+stu.getName()+","+stu.getAge());
        }

        Set<String> keys = mapStu.keySet();
        for (String key : keys) {
            Student Stu = mapStu.get(key);
            System.out.println(key+"=="+Stu.getAge()+"."+Stu.getName());
        }


        // 使用Collections对ArrayList<Student>进行排序
        ArrayList<Student> arrayStu = new ArrayList<Student>();
        Student st1 = new Student("tommy", 23);
        Student st12 = new Student("yale", 34);
        Student st13 = new Student("harvard", 22);
        Student st14 = new Student("columbia", 22);

        arrayStu.add(st1);
        arrayStu.add(st12);
        arrayStu.add(st13);
        arrayStu.add(st14);

        Collections.sort(arrayStu, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s1.getAge()-s2.getAge();
                int num2 = num == 0? s1.getName().compareTo(s2.getName()):num;

                return num2;
            }
        });


        for (Student s : arrayStu) {
            System.out.println(s.getName()+","+s.getAge());
        }


    }
}
