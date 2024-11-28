package com.a23Properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class GuessNumberDemo {
    public static void main(String[] args) throws IOException {
        // 玩猜数字游戏
        //先加载记录游戏次数的文件count.properties
        Properties prop = new Properties();
        FileReader fr = new FileReader("MCUserManager/count.property");
        prop.load(fr);
        fr.close();

        String count = prop.getProperty("count");
        int num = Integer.parseInt(count);
        if (num >= 3) {
            System.out.println("game over");
        } else {
            // play game
            GuessNumber.start();
            num++;
            prop.setProperty("count", String.valueOf(num));
            FileWriter fw = new FileWriter("MCUserManager/count.property");
            prop.store(fw, null);
            fw.close();
        }
    }
}
