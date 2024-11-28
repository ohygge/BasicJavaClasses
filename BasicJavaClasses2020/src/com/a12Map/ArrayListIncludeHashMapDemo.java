package com.a12Map;

import java.util.*;

public class ArrayListIncludeHashMapDemo {
    public static void main(String[] args) {
        // 创建 ArrayList
        ArrayList<HashMap<String, String>> arryListHm = new ArrayList<HashMap<String, String>>();

        // 创建 hashMap
        HashMap<String, String> hm1 = new HashMap<String, String>();
        hm1.put("a", "1");
        hm1.put("b", "2");
        arryListHm.add(hm1);
        HashMap<String, String> hm12 = new HashMap<String, String>();
        hm1.put("c", "3");
        hm1.put("d", "4");
        arryListHm.add(hm12);
        HashMap<String, String> hm13 = new HashMap<String, String>();
        hm1.put("e", "5");
        hm1.put("f", "6");
        arryListHm.add(hm13);

        // 遍历
        for (HashMap<String, String> hm : arryListHm) {
            Set<String> keySet = hm.keySet();
            for (String key : keySet) {
                String value = hm.get(key);
                System.out.println(key + "," + value);
            }
        }

        System.out.println("---------------------");
        // 查询任意字符串中出现各个字母的次数
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        String aa = "integer";
        for (int i = 0; i < aa.length(); i++) {
            char key = aa.charAt(i);
            System.out.println("key===" + key);
            Integer value = hm.get(key);
            System.out.println("value==" + value);
            if (value == null) {
                hm.put(key, 1);
            } else {
                value++;
                hm.put(key, value);
            }
        }
        // 遍历hashmap集合，得到键值对，按照要求进行拼接
        StringBuilder sb = new StringBuilder();
        Set<Character> characters = hm.keySet();
        for (Character key : characters) {
            Integer num = hm.get(key);
            sb.append(key).append("(").append(num).append(")");
        }
        System.out.println("result==" + sb.toString());

        System.out.println("-----------Poker 1-----------");
        // 一、Poker纸牌玩斗地主的随机发牌和看牌
        // 准备一副牌
        ArrayList<String> poker = new ArrayList<String>();

        String[] hua = {"♥️", "♠️", "♦️", "♣️"};
        String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String h : hua) {
            for (String num : number) {
                poker.add(h + num);
            }
        }
        poker.add("BKing");
        poker.add("SKing");

        // 洗牌
        Collections.shuffle(poker);

        // 发牌 三个玩家+3张底牌
        ArrayList<String> p1 = new ArrayList<String>();
        ArrayList<String> p12 = new ArrayList<String>();
        ArrayList<String> p13 = new ArrayList<String>();
        ArrayList<String> p14 = new ArrayList<String>();


        for (int i = 0; i < poker.size(); i++) {
            String pNum = poker.get(i);
            if (i >= poker.size() - 3) {
                p14.add(pNum);
            } else if (i % 3 == 0) {
                p1.add(pNum);
            } else if (i % 3 == 1) {
                p12.add(pNum);
            } else if (i % 3 == 2) {
                p13.add(pNum);
            }
        }

        lookPoker("tom", p1);
        lookPoker("care", p12);
        lookPoker("jake", p13);
        lookPoker("底牌", p14);


        // 二、Poker纸牌玩斗地主的随机发牌和看牌排序
        System.out.println("----------Poker 2-----------");
        // 创建HashMap ，k-v 是编号和牌
        HashMap<Integer, String> pokerMap = new HashMap<Integer, String>();
        // 创建编号ArrayList
        ArrayList<Integer> numList = new ArrayList<Integer>();
        String[] hua2 = {"♥️", "♠️", "♦️", "♣️"};
        String[] number2 = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int index = 0;

        for (String num : number2) {
            for (String  h : hua2) {
                pokerMap.put(index, h + num);
                numList.add(index);
                index++;
            }
        }

        pokerMap.put(index, "BKing");
        numList.add(index);
        index++;
        pokerMap.put(index, "SKing");
        numList.add(index);

        // 洗牌的编码号
        Collections.shuffle(numList);

        // 发牌
        // 发牌 三个玩家+3张底牌
        TreeSet<Integer> p21 = new TreeSet<Integer>();
        TreeSet<Integer> p22 = new TreeSet<Integer>();
        TreeSet<Integer> p23 = new TreeSet<Integer>();
        TreeSet<Integer> p24 = new TreeSet<Integer>();
        for (int i = 0; i < numList.size(); i++) {
            int pNum = numList.get(i);
            if (i >= numList.size() - 3) {
                p24.add(pNum);
            } else if (i % 3 == 0) {
                p21.add(pNum);
            } else if (i % 3 == 1) {
                p22.add(pNum);
            } else if (i % 3 == 2) {
                p23.add(pNum);
            }
        }

        System.out.println("==========");
        System.out.println("===="+p21.toString());
        lookTreePoker("p21", p21, pokerMap);
        lookTreePoker("p22", p22, pokerMap);
        lookTreePoker("p23", p23, pokerMap);
        lookTreePoker("p24", p24, pokerMap);


    }

    public static void lookPoker(String name, ArrayList<String> arrayNum) {
        System.out.print(name + " 的牌是：");
        for (String a : arrayNum
        ) {
            System.out.print(a + " ");
        }

        System.out.println();
    }

    public static void lookTreePoker(String name, TreeSet<Integer> treeNum, HashMap<Integer, String> pokerMap) {
        System.out.print(name + " 的牌是：");

        for (Integer i : treeNum) {
            String poker = pokerMap.get(i);
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
