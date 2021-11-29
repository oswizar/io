package com.oswizar.designpattern.abstractfactory;


public class CourseTest {

    public static void main(String[] args) {
        CourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.create().record();

        CourseFactory pythonCourseFactory = new PythonCourseFactory();
        pythonCourseFactory.create().record();
    }
}
