/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: Base64Utils
 * Author:   com.xiexing
 * Date:     2019/1/8 14:23
 * Description:
 */
package com.xiexing.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Base64Utils;

public class BASE64Utils {

    public static void main(String[] args) throws Exception {
        String param = "测试BASE64加密的明文";
        System.out.println("加密前的明文:" + param);
        System.out.println("===============================================================");

        String data1 = Base64Utils.encodeToString(param.getBytes());
        System.out.println("使用spring[Base64Utils]加密后:" + data1);
        // 通过字符串为参数进行解密
        byte[] result1 = Base64Utils.decodeFromString(data1);
        System.out.println("使用spring[Base64Utils]解密后:" + new String(result1));

        System.out.println("===============================================================");
        String data2 = Base64.encodeBase64String(param.getBytes());
        System.out.println("使用commons[Base64]加密后:" + data2);
        // 通过字符串为参数进行解密
        byte[] result2 = Base64.decodeBase64(data2);
        System.out.println("使用commons[Base64]解密后:" + new String(result2));

    }
}
