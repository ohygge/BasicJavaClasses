package com.a7Array;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {22, 11, 3, 191, 20};
        System.out.println("before array==" + arraysToString(arr));

        for (int r = 0; r < arr.length - 1; r++) { // n个数比较n-1次
            for (int u = 0; u < arr.length - 1 - r; u++) { // 每次比较完毕。下一次的数据就少一个参与
                if (arr[u] > arr[u + 1]) {
                    int temp = arr[u];
                    arr[u] = arr[u + 1];
                    arr[u + 1] = temp;
                }
            }
        }
        System.out.println("Arrays.toString==="+Arrays.toString(arr));
        System.out.println("after array==" + arraysToString(arr));
    }

    public static String arraysToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
