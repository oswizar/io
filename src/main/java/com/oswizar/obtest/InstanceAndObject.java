package com.oswizar.obtest;

/**
 * @author: oswizar
 * @date: 2019/4/1 13:18
 * @description:
 */
abstract class AbstractInstanceAndObject {}
public class InstanceAndObject {

    public static void main(String[] args) {

        // 抽象类对象声明
        AbstractInstanceAndObject abstractInstanceAndObject = null;

        // 普通类对象声明
        InstanceAndObject object = null;

        // 基础数据封装类实例化
        Integer integer = new Integer(10);

        // 普通类对象实例化
        InstanceAndObject example = new InstanceAndObject();


        System.out.println("AbstractInstanceAndObject生成对象");

        System.out.println(abstractInstanceAndObject instanceof Object);

        System.out.println(abstractInstanceAndObject instanceof AbstractInstanceAndObject);

        System.out.println(abstractInstanceAndObject+"\n");



        System.out.println("InstanceAndObject生成对象");

        System.out.println(object instanceof Object);

        System.out.println(object instanceof InstanceAndObject);

        System.out.println(object+"\n");



        System.out.println("Integer实例化对象");

        System.out.println(integer instanceof Object);

        System.out.println(integer instanceof Integer);

        System.out.println(integer.hashCode());

        System.out.println(integer+"\n");



        System.out.println("InstanceAndObject实例化对象");

        System.out.println(example instanceof Object);

        System.out.println(example instanceof InstanceAndObject);

        System.out.println(example.hashCode());

        System.out.println(example+"\n");

    }

}
