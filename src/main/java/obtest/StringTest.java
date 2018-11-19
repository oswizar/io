package obtest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.hash;

/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: obtest.StringTest
 * Author:   xiexing
 * Date:     2018/11/15 15:48
 * Description: 字符串测试
 */

public class StringTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long n;
        System.out.println("输入拼接字符串测试次数n...");
        Scanner in = new Scanner(System.in);
        n = Long.parseLong(in.next());
        System.out.println("Start... " + n);

        long start1 = System.nanoTime();
        String s1 = new String("hello");
        for (long i = 0; i < n; i++) {
            s1 += "拼接测试的字符串";
        }
        long end1 = System.nanoTime();
        long time1 = end1 - start1;
        System.out.println("用String+=拼接字符串的时间" + time1 + "ns");

        long start2 = System.nanoTime();
        String s2 = new String("hello");
        for (long i = 0; i < n; i++) {
            s2 = s2 + "拼接测试的字符串";
        }
        long end2 = System.nanoTime();
        long time2 = end2 - start2;
        System.out.println("用String=String+拼接字符串的时间" + time2 + "ns");

        long start3 = System.nanoTime();
        String s3 = new String("hello");
        for (long i = 0; i < n; i++) {
            s3 = s3.concat("拼接测试的字符串");
        }
        long end3 = System.nanoTime();
        long time3 = end3 - start3;
        System.out.println("用String.concat拼接字符串的时间" + time3 + "ns");

        long start4 = System.nanoTime();
        StringBuffer s4 = new StringBuffer("hello");
        for (long i = 0; i < n; i++) {
            s4.append("拼接测试的字符串");
        }
        long end4 = System.nanoTime();
        long time4 = end4 - start4;
        System.out.println("用StringBuffer.append拼接字符串的时间" + time4 + "ns");

        long start5 = System.nanoTime();
        StringBuilder s5 = new StringBuilder("hello");
        for (long i = 0; i < n; i++) {
            s5.append("拼接测试的字符串");
        }
        long end5 = System.nanoTime();
        long time5 = end5 - start5;
        System.out.println("用StringBuilder.append拼接字符串的时间" + time5 + "ns");

        in.close();
        System.out.println("End...");
    }



    @Test
    public void hashCodeTest() {
        String str1 = "aa";
        String str2 = "bb";
        String str3 = "aa";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        int str1hash = hash(str1,str2);
        System.out.println(str1hash);
        int str2hash = hash(str2);
        System.out.println(str2hash);

    }

}
