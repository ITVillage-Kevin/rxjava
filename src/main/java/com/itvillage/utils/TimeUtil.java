package com.itvillage.utils;

public class TimeUtil {
    public static long start;

    public static void start(){
        start = System.currentTimeMillis();
    }

    public static void sleep(long interval){
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
