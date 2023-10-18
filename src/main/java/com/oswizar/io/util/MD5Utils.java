package com.oswizar.io.util;

import org.springframework.util.DigestUtils;

public class MD5Utils {

    /**
     * MD5方法
     *
     * @param text  明文
     * @return md5  密文
     */
    public static String md5(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }

    /**
     * MD5验证方法
     *
     * @param text  明文
     * @param md5   密文
     * @return true/false
     */
    public static boolean verify(String text, String md5) {
        String md5Text = md5(text);
        return md5Text.equalsIgnoreCase(md5);
    }
}
