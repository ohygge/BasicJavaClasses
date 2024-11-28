package com.lucky;

import java.util.ArrayList;
import java.util.Scanner;

public class MCUserManager {

    public static void main(String[] args) {

        ArrayList<MCUser> mcUsersArr = new ArrayList<>();
        while (true) {
            System.out.println("===欢迎进入买菜用户管理系统===");
            System.out.println("1.add user");
            System.out.println("2.query user");
            System.out.println("3.update user");
            System.out.println("4.delete user");
            System.out.println("5.quit");
            System.out.println("Please enter your option :");

            Scanner sc = new Scanner(System.in);
            String num = sc.nextLine();

            switch (num) {
                case "1" :
//                    System.out.println("add");
                    addUser(mcUsersArr);
                    break;
                case "2" :
//                    System.out.println("query");
                    queryUser(mcUsersArr);
                    break;
                case "3" :
                    System.out.println("update waiting...");
                    break;
                case "4" :
                    System.out.println("delete  waiting.." );
                    break;
                case "5" :
                    System.out.println("exit");
                    System.exit(0);
            }


        }

    }
    // add user
    public static void addUser(ArrayList<MCUser> array){
        System.out.println("===add User info===");
        Scanner sc = new Scanner(System.in);
        System.out.println("add user sid :");
        String sid = sc.nextLine();
        System.out.println("add user name :");
        String name = sc.nextLine();
        System.out.println("add user age :");
        String age = sc.nextLine();
        System.out.println("add user adress :");
        String adress = sc.nextLine();

        MCUser user = new MCUser();
        user.setSid(sid);
        user.setName(name);
        user.setAge(age);
        user.setAdress(adress);

        array.add(user);

        System.out.println("===add User success!");

    }

    // query user
    public static void queryUser(ArrayList<MCUser> mcUsersArr){
        System.out.println("===query User info===");
        System.out.println("sid\tname\tage\tadress");
       for (int i = 0;i<mcUsersArr.size();i++){
           MCUser user = mcUsersArr.get(i);
           System.out.println(user.getSid()+"\t"+user.getName()+"\t"+user.getAge()+"\t"+user.getAdress());
       }
    }

}


















