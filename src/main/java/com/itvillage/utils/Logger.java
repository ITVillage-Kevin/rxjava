package com.itvillage.utils;

public class Logger {
    public static void don(Object obj){
        long time = System.currentTimeMillis() - TimeUtil.start;
        System.out.println("doOnNext() | " + Thread.currentThread().getName() + " | " + time + " | " + obj);
    }

    public static void dos(Object obj){
        long time = System.currentTimeMillis() - TimeUtil.start;;
        System.out.println("doOnSuccess() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void on(Object obj){
        long time = System.currentTimeMillis() - TimeUtil.start;;
        System.out.println("onNext() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void oe(Object obj){
        long time = System.currentTimeMillis() - TimeUtil.start;;
        System.out.println("onError() | " + Thread.currentThread().getName() + " | " + time + " | "  + obj);
    }

    public static void oc(){
        long time = System.currentTimeMillis() - TimeUtil.start;
        System.out.println("onComplete() | " + Thread.currentThread().getName() + " | " + time + " | " );
    }

    public static void os(Object obj){
        long time = System.currentTimeMillis() - TimeUtil.start;
        System.out.println("onSuccess() | " + Thread.currentThread().getName() +  " | " + time + " | " + obj);
    }
}
