package com.xiexing.obtest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

import static java.util.Objects.hash;

/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: com.xiexing.obtest.StringTest
 * Author:   com.xiexing
 * Date:     2018/11/15 15:48
 * Description: 字符串测试
 */
@Slf4j
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

    @Test
    public void stringMapTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "小明");
        map.put("key2", "小冰");
        map.put("key3", "小华");

        try{
            String code1 = map.get("key").toString();
            String code = String.valueOf(map.get("key"));
            System.out.println(code);
            if (code == "null") {
                System.out.println("ok1");
            }
            if ("null".equals(code)) {
                System.out.println("ok2");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("111111111111111111111111");
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }


    @Test
    public void subStringTest() {

        String massage1 = "A111a我司评估价格为XXX，请修改";
        String massage2 = "a222b我司评估价格为XXX，请修改";
        System.out.println(massage1.substring(0,5));
        System.out.println("车价过高,贷款申请已被拒绝," + StringUtils.substringBefore(massage1,"，"));
        System.out.println(massage1.compareTo(massage2));
        System.out.println(massage1.compareToIgnoreCase(massage2));

    }



    @Test
    public void nullAndBankTest() {
        String pptyAreaName=null;
        System.out.println(pptyAreaName);
        System.out.println(String.valueOf(pptyAreaName));
        pptyAreaName = null;
        String pptyAddr = null;
        String pptyAddrDetail = pptyAreaName + pptyAddr;
        System.out.println(pptyAddrDetail);

        String url = "heoo";
        url = url+"haha";
        System.out.println(url);

        StringBuffer stringBuffer = null;
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println((Object) null);
        System.out.println(stringBuilder);
    }


    @Test
    public void  indexOfTest() {
        String s = "5年期收益曲线(2-)";

        int startIndex = s.indexOf("(");
        log.info("开始下标为：{}",startIndex);

        int endIndex = s.indexOf(")");
        log.info("endIndex为：{}",endIndex);

        int secondIndex = s.indexOf(")",startIndex);
        log.info("第二下标为：{}",secondIndex);
        String subStr = s.substring(startIndex+1,endIndex);
        log.info("截取的字串为：{}",subStr);
        log.info(s.replace(subStr,"2"));
        s = s.replace(subStr,"2");

        log.info(s);
    }



    @Test
    public void intOrInteger() {
        String s = "123555";
        String substring = s.substring(3, 5);
        System.out.println(s);

        System.out.print("1111111111111111");
        System.out.print("\r\n");
        System.out.print("2222222222222222");
        System.out.print("\r");
        System.out.print("\r");
        System.out.print("3333333333333333");
        System.out.print("\r\n");
        System.out.print("\r\n");
        System.out.print("4444444444444444");
        List list = null;
        System.out.println(list);
    }





}
