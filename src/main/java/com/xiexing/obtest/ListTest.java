package com.xiexing.obtest;

import com.xiexing.entity.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Field;
import java.util.*;


public class ListTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    static double basic;

    public static double getBasic() {
        return basic;
    }

    public static void setBasic(double basic) {
        ListTest.basic = basic;
    }

    @Test
    public void listTest(){
        List<Person> list = new ArrayList<>();
//        list = null;
        System.out.println(list);
        System.out.println(String.valueOf(list));
//        list.add(new Person("小","明",11));
//        list.add(new Person("小","冰",12));
//        list.add(new Person("小","华",13));

        System.out.println(list);

        for (Person person:list) {
            if (person.getAge() == 12) {
                person.setAge(15);
            }
        }

        System.out.println(list);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> integers1 = integers.subList(1, 3);

        new ArrayList<Integer>();


        List<String> list1=new ArrayList<String>();
        list1.add("王利虎");
        list1.add("张三");
        list1.add("李四");
        int size=list.size();
        Object[] objects = list1.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println(list1.subList(0,3));


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
    public void arrayListTest() {
        List<String> list1=new ArrayList<String>();
        list1.add("王利虎");
        list1.add("张三");
        list1.add("李四");
        list1.add("李四1");
        list1.add("李四2");
        list1.add("李四3");

//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println("sss" + i);
//            if(list1.contains("张三")) {
//                list1.remove(i);
//                System.out.println(i);
//            } else {
//                System.out.println(i);
//            }
//        }
        System.out.println(list1);
        System.out.println(list1.subList(0,8));

    }

    public static void main(String[] args) throws NoSuchFieldException {
        int i;
        System.out.println("000:"+basic + ":111");
        ListTest listTest = new ListTest();
        Field[] fields = listTest.getClass().getDeclaredFields();
        Field basic = listTest.getClass().getDeclaredField("basic");
        System.out.println(Arrays.toString(fields));
        System.out.println(fields[1].getType() + ":" +fields[1].getName());
        System.out.println(listTest.getClass());

        System.out.println();

        System.out.println(Integer.MAX_VALUE);




//        System.out.println(listTest.getClass().getMethod("setBasic",));
// byte short int long char boolean float double
    }



}
