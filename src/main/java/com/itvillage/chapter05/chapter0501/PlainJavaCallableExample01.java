package com.itvillage.chapter05.chapter0501;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PlainJavaCallableExample01 {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new SumCallable();
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

    public static class SumCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // 시간이 오래 걸리는 작업
            Thread.sleep(5000L);
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
