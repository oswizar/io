package com.oswizar.io.obtest;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.FutureTask;

public class ThreadPoolTest {
//    ExecutorService executors = Executors.newFixedThreadPool(5);

//    Executor executor = null;

    static Map<Long, Long> record = new HashMap<>();
    static Map<Long, Long> interrupt = new HashMap<>();


    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        ExecutorService executorService = new ThreadPoolExecutor(
                30, 30, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

//        record.put(Thread.currentThread().getId(), Thread.currentThread().getName());
        System.out.println("当前线程ID为:" + Thread.currentThread().getId() + "  线程名称为：" + Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {

            if (i == 5) {
                // 新建任务(任务处理逻辑)
                int def = i;
                Callable call = (Callable<Long>) () -> {
                    Long threadId = Thread.currentThread().getId();
                    String name = Thread.currentThread().getName();
                    interrupt.put((long) def, threadId);
                    System.out.println("当前线程ID为:" + threadId + "  线程名称为：" + name);

                    // 设置睡眠
                    TimeUnit.SECONDS.sleep(100);
                    return threadId;
                };


                // 接收线程执行后返回的结果对象
                FutureTask result = (FutureTask) executorService.submit(call);
//                long id = Thread.currentThread().getId();
//                Field runner = result.getClass().getDeclaredField("runner");

                Object callResult = null;
                try {
                    // 如果在超时时间内，没有数据返回：则抛出TimeoutException异常
//                    V get(long var1, TimeUnit var2) throws InterruptedException, ExecutionException, TimeoutException;


//                    callResult = result.get(50, TimeUnit.SECONDS);
                    callResult = result.get();
//                    if (callResult==null) {
//                        interrupt.put((Long) myThreadId, Thread.currentThread().getName());
//
//                    }

                    System.out.println("Future获取当前线程返回的结果：" + callResult);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException发生");
                } catch (ExecutionException e) {
                    System.out.println("ExecutionException发生");
//                } catch (TimeoutException e) {
////                    interrupt.put((Long) myThreadId, Thread.currentThread().getName());
//                    System.out.println("TimeoutException发生，线程超时报错");
////                    Thread.currentThread().interrupt();
//                    // 如果参数为true并且任务正在运行，那么这个任务将被取消
//                    // 如果参数为false并且任务正在运行，那么这个任务将不会被取消
////                    result.cancel(false);
////                    executorService.shutdownNow();
                }
                Thread.sleep(2000);
            } else {
                int def = i;
                Callable call = (Callable<Long>) () -> {
                    Long threadId = Thread.currentThread().getId();
                    String name = Thread.currentThread().getName();
                    record.put((long) def, threadId);
                    System.out.println("当前线程ID为:" + threadId + "  线程名称为：" + name);
                    return  threadId;
                };

                // 接收线程执行后返回的结果对象
                Future result = executorService.submit(call);
                try {
                    // 如果在超时时间内，没有数据返回：则抛出TimeoutException异常
                    Object callResult = result.get(1, TimeUnit.SECONDS);
                    System.out.println("Future获取当前线程返回的结果：" + callResult);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException发生");
                } catch (ExecutionException e) {
                    System.out.println("ExecutionException发生");
                } catch (TimeoutException e) {
                    System.out.println("TimeoutException发生，线程超时报错");
                }
                Thread.sleep(500);
            }

            System.out.println("-------------------------------------------------");

        }

        System.out.println("--------------------------------------------------");
        System.out.println("线程总数为：" + bean.getThreadCount());

        Set<Long> keySet = record.keySet();
        // 查看线程池清单
        for (Long key : keySet) {
            System.out.println("线程id:" + key + "线程名称:" + record.get(key));
        }

        System.out.println("==================================================");

        // 中断线程池中阻塞的线程
        Set<Long> keys = interrupt.keySet();
        for (Long key : keys) {
            if(key==5) {
                System.out.println("线程id:" + key + "  线程名称:" + interrupt.get(key));
                Thread thread = findThread(interrupt.get(key));
                System.out.println("查找出来的线程为：" + thread.getName());
                thread.interrupt();
                while (!thread.isInterrupted() && true) {
                    System.out.println("成功中断线程---------------------------");
                }

            }

        }


        System.out.println("==================================================");

//        // 验证阻塞的线程是否成功中断
//        for (Long key : keySet) {
//            System.out.println("线程id:" + key + "  线程名称:" + record.get(key));
//        }




        printAllThreadList();

        Thread.sleep(10000);

        printRunningThreadList();





        // 关闭线程池
//        executorService.shutdown();
//        Future;
//
//        Runnable;
//        Callable;
//        Thread;
//
//        RunnableFuture;
//        FutureTask;
    }

    /**
     * 根据线程id查找线程
     *
     * @param threadId
     * @return
     */
    public static Thread findThread(long threadId) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while (group != null) {
            Thread[] threads = new Thread[(int) (group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for (int i = 0; i < count; i++) {
                if (threadId == threads[i].getId()) {
                    System.out.println("根据线程id查找线程成功！");
                    return threads[i];
                }
            }
            group = group.getParent();
        }
        return null;
    }

    /**
     * 打印当前虚拟机所有线程清单
     */
    public static void printAllThreadList() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        // 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        // 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
        // 获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slackList);
        // copy into a list that is the exact size
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
        System.out.println("Thread list size == " + list.length);
        for (Thread thread : list) {
            System.out.println("线程ID: " + thread.getId() + " 线程名称: " + thread.getName());
        }
    }

    /**
     * 打印当前虚拟机活动的线程数清单
     */
    public static void printRunningThreadList() {
        Thread[] ts = new Thread[Thread.activeCount()];
        Thread.enumerate(ts);
        for (Thread t : ts) {
            System.out.println("线程ID: " + t.getId() + " 线程名称: " + t.getName());
        }
    }
}
