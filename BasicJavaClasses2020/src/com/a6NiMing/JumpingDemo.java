package com.a6NiMing;

public class JumpingDemo {
    public static void main(String[] args) {
        JumpingOperator jo = new JumpingOperator();
        Jumping j = new Cat();
        jo.method(j);

        System.out.println("------");
        jo.method(
                // 匿名类
                new Jumping() {
                    @Override
                    public void jump() {
                        System.out.println("Dog jumping");
                    }
                }
        );
    }
}
