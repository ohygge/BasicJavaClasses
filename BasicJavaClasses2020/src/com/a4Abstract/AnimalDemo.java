package com.a4Abstract;

public class AnimalDemo {
    public static void main(String[] args) {
        /*抽象类有构造方法但是不能实例化，是用于子类访问父类数据的初始化*/
        // 创建对象按照多态的方式
        Animal an = new Cat();
        an.setName("rose");
        an.setAge(24);
        System.out.println(an.getName()+","+an.getAge());
        an.eat();
        an.jumping();

        System.out.println("-------");
        Animal a = new Dog("jack",11);
        System.out.println(a.getName()+","+a.getAge());
        a.eat();
    }
}
// 抽象类和抽象方法必须使用abstract关键字
// 抽象类中不一定有抽象方法，但是有抽象方法的类一定是抽象类
// 抽象类不能实例化，但是可以参照多态的方式，通过子类对象实例化（抽象类多态）
// 抽象类的子类：要么重写抽象类中的所有抽象方法；要么子类也是抽象类