package com.oswizar.io.temp;

public class SyncTest {
    public static void main(String[] args) {
        synchronized (SyncTest.class) {
            System.out.println("hello");
        }
    }
}
