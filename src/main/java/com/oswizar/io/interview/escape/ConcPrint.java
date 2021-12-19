package com.oswizar.io.interview.escape;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcPrint extends Thread {
    int f1 = 1;
    static int f11 = 11;

    public static Semaphore s1 = new Semaphore(0);
    public static Semaphore s2 = new Semaphore(0);


    public static AtomicInteger i1 = new AtomicInteger(0);
    public static AtomicInteger i2 = new AtomicInteger(0);

    private static final Object obj = new Object();

    public static void main(String[] args) throws Exception {


        Thread a = new Thread(() -> {
            synchronized (obj) {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        obj.notify();
                        System.out.println("A");
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        });


        Thread b = new Thread(() -> {
            synchronized (obj) {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        obj.notifyAll();
                        System.out.println("B");
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        b.start();
        a.start();



//        Thread a = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("A");
//                    s1.release();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
//
//
//        Thread b = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                    s1.acquire();
//                    System.out.println("B");
////                    s2.release();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        });
//
//        Thread c = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                    s2.acquire();
//                    System.out.println("C");
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        });
//
//        a.start();
//        b.start();
//        c.start();


    }


//    public static void main(String[] args) throws Exception {
//
//        Thread a = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println("A");
//                i1.getAndIncrement();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//
//        Thread b = new Thread(() -> {
//            while (i1.get() != 1) {
//            }
//            try {
//                Thread.sleep(1000);
//                System.out.println("B");
//                i2.incrementAndGet();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread c = new Thread(() -> {
//            while (i2.get() != 1) {
//            }
//            try {
//                Thread.sleep(1000);
//                System.out.println("C");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        a.start();
//        b.start();
//        c.start();
//    }


}



