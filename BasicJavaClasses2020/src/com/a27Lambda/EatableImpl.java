package com.a27Lambda;

public class EatableImpl implements Eatable {

    @Override
    public void eat() {
        System.out.println("a apple a day");
    }

    @Override
    public void show() {
        System.out.println("EatableImpl show");
    }
}
