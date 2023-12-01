package com.oswizar.io.temp;

import com.oswizar.io.sample.entity.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;


@Slf4j
public class ZoneTest {

    private static final Object lock = new Person();

    public static void main(String[] args) throws Exception {


        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> queue = new LinkedList<>();

        System.out.println(System.currentTimeMillis());




        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        Runnable runnable = () -> {
            System.out.println("runnable");
            int i = 1 / 0;
        };

        Callable<String> callable = () -> {
            System.out.println("callable");
            int i = 1 / 0;
            return "ok";
        };

//        FutureTask<String> task = new FutureTask<>(callable);
//        new Thread(task).start();
//        task.get();
//        System.out.println(task.get());

//        threadPool.execute(runnable);


        Future<?> future1 = threadPool.submit(runnable);
//        Object res1 = future1.get();

        try {
            Future<String> future2 = threadPool.submit(callable);
            String res2 = future2.get();
        } finally {
            threadPool.shutdown();
        }

    }

    static class MyRejectedHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("任务拒绝");
        }
    }


    public void helper() {
    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int start = 0;
        int maxLen = 1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i + 1) > maxLen && validPalindromic(arr, i, j)) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    public static boolean validPalindromic(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int countSubstrings(String s) {
        int len = s.length();
        if (len < 2) {
            return 1;
        }
        int count = len;
        char[] arr = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (validPalindromic(arr, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

}
