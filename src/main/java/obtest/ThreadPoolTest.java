package obtest;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.*;

public class ThreadPoolTest {
//    ExecutorService executors = Executors.newFixedThreadPool(5);

//    Executor executor = null;


    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                3, 30, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();


        for (int i = 0; i < 30; i++) {

            int index = i;
            executorService.execute(() -> {
                System.out.println(index);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        System.out.println("当前线程总数为："+bean.getThreadCount());

        executorService.shutdown();



    }


}
