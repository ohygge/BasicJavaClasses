package com.a3DuoTai;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal an = new Cat();
        an.setName("coffee");
        an.setAge(12);
        System.out.println(an.getName()+","+an.getAge());
        an.eat();

        System.out.println("=========");

        an = new Dog("tom",11);
        System.out.println(an.getName()+","+an.getAge());
        an.eat();

        System.out.println("=========");


    }

}
// 成员变量：编译看左边，执行看左边
// 成员方法：编译看左边，执行看右边；因为成员方法有重写