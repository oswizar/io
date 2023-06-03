package com.oswizar.io.sample;

import java.util.Date;
import java.util.concurrent.*;


public class FutureTest {}

class pool {
    private static class Caller implements Callable<Boolean> {
        @Override
        public Boolean call() {
            try {
                Thread.sleep(10000);
                System.out.println(new Date());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    private static class Runner implements Runnable {
        @Override
        public void run() {
            ExecutorService excutor = Executors.newSingleThreadExecutor();
            Future<Boolean> future = excutor.submit(new Caller());
            try {
                future.get(1, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                System.out.println("timeout");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                excutor.shutdownNow(); // 强制终止任务
            }
        }
    }

    public static void main(String[] args) {

//        ScheduledFuture
//        ScheduledThreadPoolExecutor

        ScheduledExecutorService service
                = Executors.newScheduledThreadPool(30);
        service.scheduleAtFixedRate(
                new Runner(), 0, 1, TimeUnit.SECONDS);
    }
}
