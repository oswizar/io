package com.oswizar.algorithm.share;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Digital {

    @Test
    public void print() throws UnsupportedEncodingException {
        String s = DigestUtils.sha512Hex("123");
        System.out.println(s);

    }
}
