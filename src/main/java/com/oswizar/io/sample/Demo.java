package com.oswizar.io.sample;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.FutureTask;

public class Demo {
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

        for (int i = 0; i < 10; i++) {

            if (i == 5) {
                // 新建任务(任务处理逻辑)
                int def = i;
                Callable call = (Callable<Long>) () -> {
                    Long threadId = Thread.currentThread().getId();
                    String name = Thread.currentThread().getName();
                    record.put((long) def, threadId);
                    interrupt.put((long) def, threadId);

                    // 设置睡眠
                    try {
                        TimeUnit.SECONDS.sleep(1000);
                        System.out.println("55555555555当前线程ID为:" + threadId + "  线程名称为：" + name);
                    } catch (InterruptedException e) {
                        System.out.println("当前线程已中断");
                    }


                    return threadId;
                };
                // 接收线程执行后返回的结果对象
                FutureTask result = (FutureTask) executorService.submit(call);

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
                FutureTask result = (FutureTask) executorService.submit(call);

            }

            System.out.println("-------------------------------------------------");

        }
        Thread.sleep(5000);

        System.out.println("线程总数为：" + bean.getThreadCount());

        Set<Long> keySet = record.keySet();
        // 查看线程池清单
        for (Long key : keySet) {
            System.out.println("编号为: " + key + " 线程ID: " + record.get(key));
        }

        System.out.println("==================================================");

        // 中断线程池中阻塞的线程
        Set<Long> keys = interrupt.keySet();
        for (Long key : keys) {
            if(key==5) {
                System.out.println("编号为: " + key + " 线程ID: " + interrupt.get(key));
                Thread thread = findThread(interrupt.get(key));
                System.out.println("查找出来的线程为：" + thread.getName());
                thread.interrupt();
//                while (!thread.isInterrupted() && true) {
//                    System.out.println("成功中断线程---------------------------");
//                }

            }

        }


        System.out.println("==================================================");

//        // 验证阻塞的线程是否成功中断
//        for (Long key : keySet) {
//            System.out.println("线程id:" + key + "  线程名称:" + record.get(key));
//        }




        printAllThreadList();

        Thread.sleep(1000);

        printRunningThreadList();


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
                    System.out.println("根据线程id:"+threadId+" 查找到线程："+threads[i].getName());
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
        System.out.println("打印当前虚拟机所有线程清单");
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
        System.out.println("打印当前虚拟机活动的线程数清单");
        Thread[] ts = new Thread[Thread.activeCount()];
        Thread.enumerate(ts);
        for (Thread t : ts) {
            System.out.println("线程ID: " + t.getId() + " 线程名称: " + t.getName());
        }
    }
}
