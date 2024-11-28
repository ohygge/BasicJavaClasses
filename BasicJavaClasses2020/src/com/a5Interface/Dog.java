package com.a5Interface;

public class Dog extends Animal implements Jump {

    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("dog eat meat");
    }

    @Override
    public void jumping() {
        System.out.println("dog jumping");
    }
}
