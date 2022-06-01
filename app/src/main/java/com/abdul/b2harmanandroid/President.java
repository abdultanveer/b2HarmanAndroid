package com.abdul.b2harmanandroid;

public class President {
    public static President INSTANCE = new President();

    private President(){}

    public static President getInstance(){

        return  INSTANCE;
    }
}
