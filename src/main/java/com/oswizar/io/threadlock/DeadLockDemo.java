package com.oswizar.io.threadlock;

public class DeadLockDemo extends Thread {
    private final String first;
    private final String second;

    public DeadLockDemo(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained " + first);
            try {
//                Thread.sleep(1000L);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained " + second);
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockDemo d1 = new DeadLockDemo("Thread1",lockA,lockB);
        DeadLockDemo d2 = new DeadLockDemo("Thread2",lockB,lockA);
        d1.start();
        d2.start();
        try {
            d1.join();
            d2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
