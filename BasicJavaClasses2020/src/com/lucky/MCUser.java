package com.lucky;

public class MCUser {
    private String sid;

    private String name;

    private String age;

    private String adress;

    public MCUser() {
    }

    public MCUser(String sid, String name, String age, String adress) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public String getSid() {

        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


}

