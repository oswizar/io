package obtest;

import java.util.concurrent.Callable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class FutureTest {

    public static void main(String[] args) throws InterruptedException {

        FutureTask task1 = new FutureTask("OK");
        FutureTask task2 = new FutureTask("not OK");
        FutureTask task3 = new FutureTask("not OK");
        FutureTask task4 = new FutureTask("not OK");
        FutureTask task5 = new FutureTask("not OK");
        FutureTask task6 = new FutureTask("not OK");
        FutureTask task7 = new FutureTask("not OK");
        FutureTask task8 = new FutureTask("not OK");
        FutureTask task9 = new FutureTask("OK");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 50, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(100));

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);
        executor.submit(task5);
        executor.submit(task6);
        executor.submit(task7);
        executor.submit(task8);
        executor.submit(task9);
        while (executor.getActiveCount() > 0) {
            System.out.println("活跃线程为:" + executor.getActiveCount());
            Thread.sleep(3000);
        }
        System.out.println("活跃线程为:" + executor.getActiveCount());
        executor.shutdown();
    }

}


class ControlTimeOut {


    public static <T> T call(Callable<T> callable) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<T> future = executor.submit(callable);
        try {
            T t = future.get(3000, TimeUnit.MILLISECONDS);
            executor.shutdown();
            return t;
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        } catch (TimeoutException e) {
            // TODO： coding here...
            System.out.println("TimeoutException");
        }
        return null;
    }
}


class FutureTask implements Runnable {

    private String text;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        String result = ControlTimeOut.call(new CallableImpl(text));
        System.out.println(text+"============="+Thread.currentThread().getName()+"================"+result);
    }

    public FutureTask(String text) {
        super();
        this.text = text;
    }

}


class CallableImpl implements Callable<String> {
    private static final String CORRECT_KEY = "OK";
    private String key = "";

    public CallableImpl(String key) {
        this.key = key;
    }

    public String call() {
        // TODO:真正的业务逻辑
        if (CORRECT_KEY.equals(this.getKey())) {
            return "SUCCESS";
        } else {
            try {
                Thread.sleep(5000); // 阻塞。设置5秒超时，为了Future抛出TimeoutException
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FAIL";
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}