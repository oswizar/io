package com.oswizar.io.obtest;

import com.oswizar.io.util.DateUtil;
import com.oswizar.io.util.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @date: 2019/6/24 18:09
 * @author: oswizar
 * @description:
 */
public class DateConverter {

    public static void main(String[] args) {

        Date date = new Date();
        String dateStr = "2019-03-30 00:00:00";

        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        System.out.println("java.sql.Date(date.getTime()) = " + new java.sql.Date(date.getTime()));
        System.out.println("java.sql.Timestamp(date.getTime()) = " + new java.sql.Timestamp(date.getTime()));
        System.out.println("--------------------------------------------------------------------------");

        System.out.println(date);
        String beginDateStr = DateUtils.formatDate(date);

        System.out.println(beginDateStr);


        Date beginDate = DateUtils.formatBeginDay(beginDateStr);
        System.out.println(beginDate);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println(new java.sql.Timestamp(DateUtil.String2Date(dateStr).getTime()));

    }




    @Test
    public void subStrTest() {
        String time  = "201801";
        String formatTime = time.substring(0,4);
        System.out.println(time);
        System.out.println(formatTime);
        String desTime = formatTime + "-" + time.substring(4);
        System.out.println(desTime);
    }
}
