package com.oswizar.designpattern.simplefactory;

import java.util.Calendar;

public class CourseTest {
    public static void main(String[] args) {

        ICourse javaCourse = CourseFactory.create(JavaCourse.class);
        ICourse javaCourse1 = CourseFactory.create(JavaCourse.class);
        System.out.println(javaCourse.getClass() + "" + javaCourse1.getClass());

        javaCourse.record();
        ICourse pythonCourse = CourseFactory.create(PythonCourse.class);
        pythonCourse.record();
        Calendar.getInstance();
    }
}
