package com.a5Interface;

public class Cat extends Animal implements Jump {

    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("cat eat fish");
    }

    @Override
    public void jumping() {
        System.out.println("cat jumping");
    }
}
