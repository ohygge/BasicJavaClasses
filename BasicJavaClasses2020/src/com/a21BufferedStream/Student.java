package com.a21BufferedStream;

public class Student {
    private String name;
    private int chineseNum;
    private int MathNum;
    private int EnglishNum;

    public Student() {
    }

    public Student(String name, int chineseNum, int mathNum, int englishNum) {
        this.name = name;
        this.chineseNum = chineseNum;
        MathNum = mathNum;
        EnglishNum = englishNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChineseNum() {
        return chineseNum;
    }

    public void setChineseNum(int chineseNum) {
        this.chineseNum = chineseNum;
    }

    public int getMathNum() {
        return MathNum;
    }

    public void setMathNum(int mathNum) {
        MathNum = mathNum;
    }

    public int getEnglishNum() {
        return EnglishNum;
    }

    public void setEnglishNum(int englishNum) {
        EnglishNum = englishNum;
    }

    public int getSum() {
        return this.chineseNum + this.MathNum + this.EnglishNum;
    }
}
