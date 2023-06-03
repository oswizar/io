package com.oswizar.io.designpattern.singleton;

public class SingletonTest {

    public static void main(String[] args) {
//        Object object1 = ContainerSingleton.getInstance(Course.class);
//        Object object2 = ContainerSingleton.getInstance(Course.class);
//        Object object3 = ContainerSingleton.getInstance(Course.class);
//
//        System.out.println(object1);
//        System.out.println(object2);
//        System.out.println(object3);

        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());
        thread1.start();
        thread2.start();

        System.out.println("End");
    }
}


class ExecutorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
