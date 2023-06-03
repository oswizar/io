package com.oswizar.io.sample;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GitUpdateTest {

    public static void main(String[] args) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        c.add(Calendar.DATE, 30);
        String s = sf.format(c.getTime());
        System.out.println(s);

    }
}
