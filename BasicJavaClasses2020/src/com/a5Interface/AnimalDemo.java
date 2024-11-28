package com.a5Interface;

public class AnimalDemo {

    public static void main(String[] args) {
        Jump j = new Cat();
        j.jumping();
        System.out.println("-------");

        Animal an = new Cat("tom",22);
        an.eat();
        System.out.println(an.getAge()+"+"+an.getName());

        System.out.println("-----");
        Cat cat = new Cat("rose",12);
        cat.eat();
        cat.jumping();
    }

}
// interface -- implements
// 接口多态，实现类对象实例化；多态前提是有继承或实现关系，有方法重写
// 有父（类/接口）引用指向（子/实现）类对象
// 接口实现类必须重写接口中的所有抽象方法，或者是抽象类

/*
* 抽象类和接口区别
*
* 1、成员区别
*       抽象类：变量，常量；有构造方法；有抽象方法也有非抽象方法
*       接口：  常量；抽象方法
*
* 2、关系区别
*       类与类：继承；单继承
*       类与接口：实现，单/多实现
*       接口与接口：继承，单/多继承
* */