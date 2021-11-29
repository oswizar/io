package com.oswizar.concurrency;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable = () -> System.out.println("任务被执行,线程:" + Thread.currentThread().getName());

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("任务被执行,线程:" + Thread.currentThread().getName());
                return "123456";
            }
        };

        Future<?> submit = executorService.submit(runnable);
        Object o = submit.get();
        System.out.println(o);

        System.out.println("----------------------------------");
        Future<?> call = executorService.submit(callable);
        Object r = call.get();
        System.out.println(r);

        System.out.println("----------------------------------");



        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
    }

}
