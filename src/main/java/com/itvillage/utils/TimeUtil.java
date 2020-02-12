package com.itvillage.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static long start;
    public static long end;
    private String currentTime;
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void start(){
        start = System.currentTimeMillis();
    }

    public static void end(){
        end = System.currentTimeMillis();
    }

    public static String getCurrentTime(){
        return LocalTime.now().format(formatter);
    }

    public static void sleep(long interval){
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
