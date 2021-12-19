package com.oswizar.io.designpattern.abstractfactory;

public class PythonCourseFactory extends CourseFactory{
    @Override
    protected ICourse create() {
        super.init();
        return new PythonCourse();
    }
}
