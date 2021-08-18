package com.xiexing.algorithm.share;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class Digital {

    @Test
    public void print() throws UnsupportedEncodingException {
        String s = DigestUtils.sha512Hex("123");
        System.out.println(s);

    }
}
