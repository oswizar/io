package com.oswizar.io.designpattern.abstractfactory;

public class JavaCourseFactory extends CourseFactory{
    @Override
    protected ICourse create() {
        super.init();
        return new JavaCourse();
    }
}
