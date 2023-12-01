package com.oswizar.io.interview.nowcoder;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class MingRandomNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt() && count > 0) { // 注意 while 处理多个 case
            int a = in.nextInt();
            set.add(a);
            count--;
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
