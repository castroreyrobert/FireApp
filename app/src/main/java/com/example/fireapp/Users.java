package com.example.fireapp;

/**
 * Created by castroreyrobert on 4/1/17.
 */

public class Users {

    private String mName;
    private String mAddres;
    private String mAge;

    public Users(String name, String addres, String age) {
        mName = name;
        mAddres = addres;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public String getAddres() {
        return mAddres;
    }

    public String getAge() {
        return mAge;
    }
}
