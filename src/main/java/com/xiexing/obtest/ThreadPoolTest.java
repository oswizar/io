package com.xiexing.obtest;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.*;
import java.util.concurrent.FutureTask;

public class ThreadPoolTest {
//    ExecutorService executors = Executors.newFixedThreadPool(5);

//    Executor executor = null;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(
                30, 30, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        for (int i = 0; i < 30; i++) {
            if(i==5) {

                int index = i;
                executorService.submit(() -> {
                    System.out.println(index);
//                return 5;
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                });
                Thread.sleep(5000);
                System.out.println("55555当前线程为："+bean.getThreadCount());
            } else {
                int index = i;
                executorService.submit(() -> {
                    System.out.println(index);
//                return 5;
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                });
                Thread.sleep(500);
                System.out.println("当前线程为："+bean.getThreadCount());

            }



        }

        System.out.println("线程总数为："+bean.getThreadCount());

        executorService.shutdown();


//        Future;
//
//        Runnable;
//        Callable;
//        Thread;
//
//        RunnableFuture;
//        FutureTask;




    }


}
