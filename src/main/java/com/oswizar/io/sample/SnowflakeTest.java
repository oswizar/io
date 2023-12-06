package com.oswizar.io.sample;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SnowflakeTest {

    public static void main(String[] args) throws Exception {
        //41位二进制最小值
        String minTimeStampStr = "00000000000000000000000000000000000000000";
        //41位二进制最大值
        String maxTimeStampStr = "11111111111111111111111111111111111111111";
        //转10进制
        long minTimeStamp = new BigInteger(minTimeStampStr, 2).longValue();
        System.out.println(minTimeStamp);
        long maxTimeStamp = new BigInteger(maxTimeStampStr, 2).longValue();
        System.out.println(maxTimeStamp);
        System.out.println(Long.MAX_VALUE);
        //一年总共多少毫秒
        long oneYearMills = 1L * 1000 * 60 * 60 * 24 * 365;
        System.out.println(oneYearMills);
        //算出最大可以多少年
        System.out.println((maxTimeStamp - minTimeStamp) / oneYearMills);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = dateFormat.parse("2046-11-11 23:22:22");
        System.out.println(parse.getTime());

        Date date = new Date(1288834974657L);
        System.out.println("业务开始时间：" + dateFormat.format(date));
        Snowflake snowflake = IdUtil.getSnowflake(0, 0);
        System.out.println(snowflake.nextId());
    }

}
