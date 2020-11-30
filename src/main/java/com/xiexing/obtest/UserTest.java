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
