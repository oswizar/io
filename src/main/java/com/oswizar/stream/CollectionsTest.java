package com.oswizar.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author : oswizar
 * @date : 2019/9/3 11:17
 * @description :
 */
public class CollectionsTest {

    @Test
    public void printTest() {

        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

//        List list = Arrays.asList("one two three four five".split(" "));
////        List list = Arrays.asList("one", "two", "three", "four", "five");
//        System.out.println(list);
////        Collections.sort(list);
//        Collections.reverse(list);
//        System.out.println(list);


//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2);
//                })
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .map(s -> {
//                    System.out.println("map : " + s);
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.println("forEach : " + s));

    }
}
