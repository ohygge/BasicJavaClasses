package com.a2Extends;

public class PersonDemo {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("tommy");
        st.setAge(12);
        System.out.println(st.getName() + "\t" + st.getAge());
        st.study();

        System.out.println("============");

        Student st2 = new Student("jane", 23);
        System.out.println(st2.getName() + "," + st2.getAge());
        st2.study();

    }
}
