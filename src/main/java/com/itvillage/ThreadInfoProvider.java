package com.itvillage;

public class ThreadInfoProvider {
    public static String getCurrentThreadName(){
        return Thread.currentThread().getName();
    }
}
