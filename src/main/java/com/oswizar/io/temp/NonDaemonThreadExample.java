package com.oswizar.io.temp;

public class NonDaemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            System.out.println("Daemon thread is running...");

            // 创建一个新线程
            Thread nonDaemonThread = new Thread(() -> {
                try {
                    System.out.println("Non-daemon thread is running...");
                    Thread.sleep(5000);
                    System.out.println("Non-daemon thread has finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // 显式地将新线程设置为用户线程
            nonDaemonThread.setDaemon(false);
            nonDaemonThread.start();
        });

        // 将线程设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();

        // 主线程运行2秒后结束
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is finished.");
    }
}
