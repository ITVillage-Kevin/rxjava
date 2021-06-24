package com.itvillage.chapter05.chapter0501;

import java.util.concurrent.*;

public class PlainJavaCallableExample02 {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new SumCallable();
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(callable);

        System.out.println(future.get());

        executorService.shutdown();
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
