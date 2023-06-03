package com.oswizar.io.sample;

import com.oswizar.io.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TokeTest {
    private static int length;

	public static void main(String[] args) {
        String appid = "test001"; // 平台提供的应 用编号

        String secret = "a8f0092477ccd6f7133dcfe8819aac4f"; // 平台提供的应 用秘钥

        String nonceStr = "18c3f6b565bca41c181937aa16792e89"; // 随机字符串串(最 大32位)

        // Long timestamp = 1586339973503L; // 时间戳
        Long timestamp = System.currentTimeMillis();
        System.out.println("当前时间毫秒数: " + timestamp);

        List<String> list = Arrays.asList(timestamp + "", appid, secret, nonceStr);
        Collections.sort(list);

        StringBuffer str1 = new StringBuffer();

        for (Object obj : list) {

            str1.append(obj.toString());

        }

        String unicodeString = "\\u6307\\u5B9APOJO\\u626B\\u63CF\\u5305\\u6765\\u8BA9mybatis\\u81EA\\u52A8\\u626B\\u63CF\\u5230\\u81EA\\u5B9A\\u4E49POJO";

        System.out.println("unicodeString: " + unicodeString);
        String utf8String = StringUtils.unicodeToString(unicodeString);


        System.out.println("unicodeToutf8: " + utf8String);

        String str = "123456";
        int length = str.length();

        String[] array = new String[23];
        int length2 = array.length;
        System.out.println(length2);
        System.out.println(length);

    }

}
