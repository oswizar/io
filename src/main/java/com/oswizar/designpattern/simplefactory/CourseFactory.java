package com.oswizar.designpattern.simplefactory;

public class CourseFactory {

    public static ICourse create(Class<? extends ICourse> clazz) {
        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
