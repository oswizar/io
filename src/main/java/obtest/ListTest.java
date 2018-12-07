package obtest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: obtest.ListTest
 * Author:   xiexing
 * Date:     2018/11/8 9:39
 * Description: List测试
 */

public class ListTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void listTest(){
        List list = new ArrayList();
//        list = null;
        System.out.println(list);
        System.out.println(String.valueOf(list));
        list.add("小明");
        list.add("小冰");
        list.add("小华");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            log.info("{}",iterator.next());

        }

        list.equals("aaa");
        System.out.println(list.hashCode());
    }


    @Test
    public void arayListTest() {
        List list = new ArrayList();
        Map map = new HashMap();
        System.out.println(list);
        System.out.println(map);
    }



}
