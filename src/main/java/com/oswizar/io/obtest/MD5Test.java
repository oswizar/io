
package com.oswizar.io.obtest;

import com.oswizar.io.util.MD5Utils;
import org.junit.Test;

public class MD5Test {
    @Test
    public void generateMD5Test() {
        String text = "测试MD5加密的明文";
        String md51 = "2a74b91c3cc6becd5802b35fe69c8107";
        String md52 = "64aaf40dda40cac6ee013ddcb7fb381c";
        MD5Utils.verify(text, md51);
        MD5Utils.verify(text, md52);
    }
}
