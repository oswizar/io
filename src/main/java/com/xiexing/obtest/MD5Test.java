/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: MD5Test
 * Author:   com.xiexing
 * Date:     2019/1/7 15:38
 * Description: MD5测试
 */
package com.xiexing.obtest;

import org.junit.Test;
import com.xiexing.util.MD5Utils;

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
