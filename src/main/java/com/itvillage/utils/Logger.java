package com.itvillage.utils;

public class Logger {
    public static void log(String msg){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println(msg + " | " + Thread.currentThread().getName() + " | " + time);
    }

    public static void log(String msg, Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println(msg + " | " + Thread.currentThread().getName() + " | " + time + " | "  +obj);
    }

    public static void log(LogType logType){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println(logType.getLogType() + " | " + Thread.currentThread().getName() + " | " + time);
    }

    public static void log(LogType logType, Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println(logType.getLogType() + " | " + Thread.currentThread().getName() + " | " + time + " | "  +obj);
    }
}
