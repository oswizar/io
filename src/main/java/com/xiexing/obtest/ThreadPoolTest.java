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
                System.out.println(index);

                // 新建任务
                Callable call = (Callable<String>) () -> {
                    // 设置2秒睡眠
                    TimeUnit.SECONDS.sleep(1);
                    return "这是线程执行结果……";
                };

                // 手动控制线程
                Future result = executorService.submit(call);
                try {
                    // 如果在超时时间内，没有数据返回：则抛出TimeoutException异常

//                    V get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException;

                    Object callResult = result.get(1, TimeUnit.SECONDS);
                    System.out.println(callResult+"555555555555555555555555555555555");
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException发生");
                } catch (ExecutionException e) {
                    System.out.println("ExecutionException发生");
                } catch (TimeoutException e) {
                    System.out.println("TimeoutException发生，线程超时报错");

                    // 如果参数为true并且任务正在运行，那么这个任务将被取消
                    // 如果参数为false并且任务正在运行，那么这个任务将不会被取消
//                    result.cancel(false);
//                    executorService.shutdownNow();
                }
                Thread.sleep(5000);
                System.out.println("55555当前线程为："+bean.getThreadCount());
            } else {
                int index = i;
                System.out.println(index);

                Callable call = (Callable<String>) () -> "这是线程执行结果……"+index;

                // 手动控制线程
                Future result = executorService.submit(call);
                try {
                    // 如果在超时时间内，没有数据返回：则抛出TimeoutException异常
                    Object callResult = result.get(1, TimeUnit.SECONDS);
                    System.out.println(callResult);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException发生");
                } catch (ExecutionException e) {
                    System.out.println("ExecutionException发生");
                } catch (TimeoutException e) {
                    System.out.println("TimeoutException发生，线程超时报错");
//                    result.cancel(false);
//                    executorService.shutdownNow();
                }
                Thread.sleep(500);
                System.out.println("当前线程为："+bean.getThreadCount());
            }
        }

        System.out.println("线程总数为："+bean.getThreadCount());

        // 关闭线程池
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
