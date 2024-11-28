package com.a10Generic;

public class GenericImpl<T> implements GenericI<T> {
    @Override
    public void show(T t) {
        System.out.println("this is show <T>"+t);
    }
}
