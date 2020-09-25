package com.xiexing.obtest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateTest {
    public static void main(String[] args) {
        showStr();
        System.out.println(test("2"));
        System.out.println("new java.util.Date()=>" + new java.util.Date());
        System.out.println("System.currentTimeMillis()=>" + System.currentTimeMillis());
        System.out.println("new java.sql.Date(System.currentTimeMillis())=>" + new java.sql.Date(System.currentTimeMillis()));
        System.out.println("new java.sql.Timestamp(System.currentTimeMillis())=>" + new java.sql.Timestamp(System.currentTimeMillis()));
    }


    public static String test(String s) {
        String rs = "123";
        try {
            if (s == "2") {
                throw new Exception();

            }

        } catch (Exception e) {
//            rs = "ok";
            e.printStackTrace();
        }

        return rs;

    }

    public static void showStr() {
        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String sum = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sum += list.get(i);
            } else {
                sum += list.get(i) + ",";
            }


        }
        String s = "1";
        String s1 = "'" + s + "'";
        System.out.println(s1);
        System.out.println(sum);
    }

    @Test
    public void testLocalDateTime() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "jason");
        String s = JSONObject.toJSONString(map);
        System.out.println(s);

    }

    @Test
    public void md5() throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        Security.addProvider(new BouncyCastleProvider());
        String str = "50.00";
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digest = str.getBytes("UTF-8");
        md.update(digest);
        digest = md.digest();

        str = convertToHexString(digest);

        System.out.println(str);

    }

    static String convertToHexString(byte data[]) {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            strBuffer.append(Integer.toHexString(0xff & data[i]));
        }
        return strBuffer.toString();
    }
}
