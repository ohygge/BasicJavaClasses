package com.a23Properties;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public GuessNumber() {
    }
    public static void start(){
        int number = new Random().nextInt(100)+1;
        while (true) {
            // 键盘输入数字 进行比对
            Scanner sc = new Scanner(System.in);
            System.out.println("please input number:");
            int guessNum = sc.nextInt();
            if (guessNum > number) {
                System.out.println("this number "+guessNum+"is bigger");
            } else if (guessNum < number) {
                System.out.println("this number "+guessNum+"is smaller");
            } else{
                System.out.println("guess right");
                break;
            }
        }
    }
}
