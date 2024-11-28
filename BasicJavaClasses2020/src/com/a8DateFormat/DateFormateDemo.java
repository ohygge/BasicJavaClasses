package com.a8DateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateFormateDemo {
    public static void main(String[] args) {
        Date nowDate = new Date();
        String s = DateUtils.DateToString(nowDate, "HH:mm:ss");
        System.out.println("now==="+s);

        // 获取某一年的二月天数 calendar对象 取3月1号 再往前一天就是2月 即得2月天数
        Calendar ca = Calendar.getInstance();
        System.out.println("=====please input year number");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        ca.set(year, 2, 1);
        ca.add(Calendar.DATE, -1);
        System.out.println("===="+ca.get(Calendar.MONTH)+1);
        int i = ca.get(Calendar.DAY_OF_MONTH);
        System.out.println("2 月天数"+i);

        int a1 = 10000000;
        int a2 = 331233;
        int a3 = 3000;
        int a4 = 200;
        int a5 = 10;
        int a6 = 5;

        int sum = a1*3+a2*93+a3*1009+a4*57800+a5*1208576+a6*8236635;
        if(sum == 389948810){
            System.out.println("yes,sum =="+sum);
        }else{
            System.out.println("no,sum =="+sum);
        }
        // sum ==128660604
        System.out.println(sum < 389948810);
        System.out.println(389948810/sum);
        System.out.println(389948810%sum);
    }
}
