package com.oswizar.designpattern.abstractfactory;

public abstract class CourseFactory {

    public void init(){
        System.out.println("初始化");
    }

    protected abstract ICourse create();
}
