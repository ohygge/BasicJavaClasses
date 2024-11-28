package com.a9CollectionDemo;

import java.util.Objects;

public class Student implements Comparable<Student>{

    private String name ;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Student s) {
//        return 0; // 0 重复元素不添加；1 升序排序；-1 降序排序
        // 按照年龄从小到大排序
        int num = this.age - s.age;
        // 年龄一样时按name字母排序
        int num2 = num == 0 ? this.name.compareTo(s.name) : num;
        System.out.println("num=="+num);
        System.out.println("num2=="+num2);
        return num2;

    }
}
