package com.itvillage.utils;

// TODO 리팩토링 필요
public class Logger {
    public static void doscr(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("doOnScribe() | " + Thread.currentThread().getName() + " | " + time + " | " + obj);
    }
    public static void don(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("doOnNext() | " + Thread.currentThread().getName() + " | " + time + " | " + obj);
    }

    public static void dos(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("doOnSuccess() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void doc(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("doOnComplete() | " + Thread.currentThread().getName() + " | " + time + " | " + obj);
    }

    public static void doe(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("doOnError() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void dodp(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("doOnDisPose() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void oscr(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("onSubscribe() | " + Thread.currentThread().getName() +  " | " + time + " | " + obj);
    }

    public static void on(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("onNext() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void oe(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("onError() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void oc(){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("onComplete() | " + Thread.currentThread().getName() + " | " + time);
    }

    public static void osc(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("onSuccess() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void cp(Object obj) {
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println("Completed a process | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void print(Object obj){
        String time = TimeUtil.getCurrentTimeFormatted();
        System.out.println(Thread.currentThread().getName() + " | " + time + " | "  +obj);
    }
}
