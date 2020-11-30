package com.xiexing.obtest;

import com.xiexing.entity.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: com.xiexing.obtest.ListTest
 * Author:   com.xiexing
 * Date:     2018/11/8 9:39
 * Description: List测试
 */

public class ListTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    static double basic;

    @Test
    public void listTest(){
        List<Person> list = new ArrayList<>();
//        list = null;
        System.out.println(list);
        System.out.println(String.valueOf(list));
        list.add(new Person("小","明",11));
        list.add(new Person("小","冰",12));
        list.add(new Person("小","华",13));

        System.out.println(list);

        for (Person person:list) {
            if (person.getAge() == 12) {
                person.setAge(15);
            }
        }

        System.out.println(list);



//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            log.info("{}",iterator.next());
//
//        }
//
//        list.equals("aaa");
//        System.out.println(list.hashCode());
    }



    @Test
    public void arayListTest() {
        List<Person> list = new ArrayList();
        Map map = new HashMap();
        System.out.println(list);
        System.out.println(map);

    }

    public static void main(String[] args) {
        int i;
        System.out.println("000:"+basic + ":111");
// byte short int long char boolean float double
    }



}
