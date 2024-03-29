package com.oswizar.io.sample.innerclass;


/**
 * @author: oswizar
 * @create: 2019/4/1 11:28
 * @description:
 */

public class OuterClass {
    private String sex = "female";
    public static String outerClassName = "outerClassName";

    /**
     * 静态内部类
     */
    static class StaticInnerClass {
        /* 在静态内部类中可以存在静态成员 */
        public static String staticInnerClassName = "staticInnerClassName";

        public void display() {
            /*
             * 静态内部类只能访问外围类的静态成员变量和方法
             * 不能访问外围类的非静态成员变量和方法
             */
            System.out.println("静态内部类访问外围类的outerClassName : " + outerClassName);
        }
    }

    /**
     * 非静态内部类
     */
    class InnerClass {

        /* 非静态内部类中不能存在静态成员 */
        public String innerClassName = "innerClassName";

        /* 非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的 */
        public void display() {
            System.out.println("非静态内部类访问外围类的sex ： " + sex);
        }
    }

    /**
     * @return void
     * @desc 外围类方法
     * @author chenssy
     * @data 2013-10-25
     */
    public void display() {
        /* 外围类访问静态内部类：内部类. */
        System.out.println("外围类访问静态内部类的staticInnerClassName : " + StaticInnerClass.staticInnerClassName);
        /* 静态内部类 可以直接创建实例不需要依赖于外围类 */
        new StaticInnerClass().display();

        /* 非静态内部的创建需要依赖于外围类 */
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();
        /* 非静态内部类的成员需要使用非静态内部类的实例才能访问 */
        System.out.println("外围类访问非静态内部类的innerClassName : " + inner.innerClassName);
        inner.display();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.display();
    }
}
