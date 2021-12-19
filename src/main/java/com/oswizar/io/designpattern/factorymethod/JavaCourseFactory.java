package com.oswizar.io.designpattern.factorymethod;

public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
//        Class<JavaCourse> clazz = JavaCourse.class;
//        try {
//            clazz.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return new JavaCourse();
    }
}
