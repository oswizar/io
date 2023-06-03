package com.oswizar.io.algorithm.test;

import org.junit.Test;

import java.util.*;

public class MathTest {

//    private MathTest() {}

//    public MathTest getInstance() {
//        if (instance == null) {
//            synchronized (MathContext.class) {
//                if (instance == null) {
//                    instance = new MathTest();
//                }
//            }
//        }
//        return instance;
//    }
    public MathTest getInstance() {
        return Inner.INSTANCE;
    }


    private static class Inner{
        public final static MathTest INSTANCE = new MathTest();
    }


    @Test
    public void  print() {
        String s = "asdf";
        String t = "a";
        int len1 = s.length();
        String[] arr = s.split("");
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        int a = 00000000000000000000000000001011;
        String as = String.valueOf(a);
        System.out.println(as);
        System.out.println(a);

        List<Integer> s1 = new ArrayList<>();
        Map<Integer,Integer> m1 = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.contains(1);
        System.out.println(Math.pow(2,2)==4L);
        m1.put(1,1);

//        s1.add(1);
//        s1.add(3);
//        s1.add(3);
        System.out.println(s1.contains(3));


        s = "A man, a plan, a canal: Panama";
        StringBuilder sb = new StringBuilder();
        sb.charAt(0);
        int nn = Integer.MAX_VALUE;
        System.out.println(sb.length());
        for (int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
            } else if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                char c = (char) (s.charAt(i) + 32);
                sb.append(c);
            } else if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        s = s.toLowerCase();

        System.out.println(s);
    }


    @Test
    public void treeTest() {
        Deque<Integer> queue =new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        map.put("马冬梅", "1");
        String s = map.put("马冬梅", "2");
        System.out.println(s);


    }


}

