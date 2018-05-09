package com.example.administrator.signin;

public class UserInfo {
    String name;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public  UserInfo(String password,String name) {
        this.password = password;
        this.name = name;
    }

    String password;
}
