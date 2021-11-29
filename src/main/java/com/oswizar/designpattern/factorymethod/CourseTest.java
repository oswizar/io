package com.oswizar.designpattern.factorymethod;

public class CourseTest {
    public static void main(String[] args) {

        ICourseFactory javaCourseFactory = new JavaCourseFactory();
        ICourse javaCourse = javaCourseFactory.create();
        javaCourse.record();
        ICourseFactory pythonCourseFactory = new PythonCourseFactory();
        ICourse pythonCourse = pythonCourseFactory.create();
        pythonCourse.record();
    }
}
