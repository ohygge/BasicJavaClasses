package com.a23Properties;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        //properties作为Map集合的使用
        Properties prop = new Properties();
        prop.put("tom","001");
        prop.put("adam","002");
        prop.put("fine","003");
        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            Object value = prop.get(key);
            System.out.println(key+","+value);
        }
        System.out.println("----------------");
        //Properties特有方法
        prop.setProperty("888","r");
        prop.setProperty("889","f");
        prop.setProperty("887","a");
        Set<String> names = prop.stringPropertyNames();
        for (String key : names) {
            String value = prop.getProperty(key);
            System.out.println(key+","+value);
        }

    }
}
