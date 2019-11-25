/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: UserTest
 * Author:   com.xiexing
 * Date:     2018/11/26 14:44
 * Description:
 */
package com.xiexing.obtest;

import com.xiexing.entity.Student;
import org.junit.Test;

public class UserTest {
    private String s;

    @Test
    public void modelTest () {
        Student student = new Student();
        System.out.println(student.getStudentName());
        System.out.println(student.toString());
        if (student==null || student.toString() == "") {
            System.out.println("11111111111111111");
        }
        Object o = student.getClass();
        System.out.println(student);
        Student student1 = student;
        System.out.println(student1);
        System.out.println(o);
    }


}
