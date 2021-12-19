package com.oswizar.io.util;

import org.springframework.util.DigestUtils;

public class MD5Utils {

    /**
     * MD5方法
     *
     * @param text 明文
     * @return md5 密文
     */
    public static String md5(String text) {
        String encodeStr = DigestUtils.md5DigestAsHex(text.getBytes());
        System.out.println("MD5加密后的字符串为:"+encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5 密文
     * @return true/false
     */
    public static boolean verify(String text, String md5) {
        String md5Text = md5(text);
        System.out.println("MD5字符串为:" + md5);
        if (md5Text.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证成功");
            return true;
        } else {
            System.out.println("MD5验证失败");
            return false;
        }
    }
}
