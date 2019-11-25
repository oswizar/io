package obtest;

import java.time.LocalTime;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 100; i++) {
//            System.out.println("new thread " + i);
        Thread t = new TimerThread();
        t.setDaemon(true);
        System.out.println("main startTime " + System.currentTimeMillis());
        System.out.println("main Start");
        t.start();
        Thread.sleep(1000);
//        t.sleep(1);
//        t.interrupt();
//        t.join();
        System.out.println("main End");
        System.out.println("main endTime " + System.currentTimeMillis());
//        }

    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            i++;
            System.out.println(i);
        }

//        for (int j = 0; j < 1000; j++) {
//            if (!interrupted()) {
//                System.out.println(j);
//            }
//
//        }


    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(System.currentTimeMillis());
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
