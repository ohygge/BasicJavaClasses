package com.lucky;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author Adam
 * @version 1.0
 * @description 双色球机选号码
 * @date 2020/12/31
 */
public class DoubleChomper {
    //双色球红球范围（所有期望值+1）
   public static int redRange = 34;
    //双色球红球个数
    public static int redFrequency = 6;
    //双色球蓝球范围
    public static int blueRange = 17;
    //双色球蓝球个数
    public static int blueFrequency = 1;
    //大乐透红球范围
    public static int leTouRedRange =36;
    //大乐透红球个数
    public static int leTouRedFrequency = 5;
    //大乐透蓝球范围
    public static int leTouBlueRange = 13;
    //大乐透蓝球范围
    public static int leTouBlueFrequency = 2;

    public static void main(String[] args) {
        getResult(10,10);
    }

    /**
     * 双色球选球
     * @param range 选球范围
     * @param number 选球个数
     * @return
     */
    private static List getTheBall(int range, int number){
        //定义接收数组
        List red_list =new ArrayList(6);
        Random rand = new Random();
        boolean[] bool = new boolean[range];
        int randInt = 0;
        //循环生成随机数去重后添加到接收数组中
        for(int i = 0; i < number ; i++) {
            do {
                randInt = rand.nextInt(range-1)+1;
            } while (bool[randInt]);
            bool[randInt] = true;
            red_list.add(randInt);
        }
        //结果集排序
        red_list.sort(Comparator.naturalOrder());
        return red_list;
    }

    /**
     * 循环打印结果
     * @param doubleColorNum 双色球生成号码注数
     * @param leTouNum 大乐透生成号码注数
     */
    public static void getResult(int doubleColorNum , int leTouNum ){
        System.out.println("双色球机选结果");
        for (int i = 0; i <doubleColorNum ; i++) {
            List red = getTheBall(redRange,redFrequency);
            List blue = getTheBall(blueRange,blueFrequency);
            System.out.println("红球： "+red+";蓝球:  "+blue);
        }
        System.out.println("大乐透机选结果");
        for (int i = 0; i <leTouNum ; i++) {
            List red = getTheBall(leTouRedRange,leTouRedFrequency);
            List blue = getTheBall(leTouBlueRange,leTouBlueFrequency);
            System.out.println("红球："+red+";   蓝球：" + blue);
        }
    }

}
