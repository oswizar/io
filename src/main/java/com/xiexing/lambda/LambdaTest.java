package com.xiexing.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.*;

/**
 * @date: 2019/5/6 14:23
 * @author: oswizar
 * @description:
 */
@Slf4j
public class LambdaTest {

    @Test
    public void show() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
//        List<String> players =  Arrays.asList(atp);
//        log.info(players.toString());
//
//        // 以前的循环方式
//        for (String player : players) {
//            System.out.println(player + "; ");
//        }
//
//        log.info("====================================================");
//        // 使用lambda表达式以及函数操作(functional operation)
//        players.forEach((player) -> System.out.println(player + ";"));
//
//        log.info("====================================================");
//        players.forEach(System.out::println);
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello world!");
//            }
//        }).start();
//
//        // 使用lambda expression
//        new Thread(() -> System.out.println("hello lambda")).start();
//
//
//
//        // 2.1使用匿名内部类
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello...");
//            }
//        };
//
//        // 2.2使用lambda
//        Runnable runnable2 = () -> System.out.println("world...");
//
//        runnable1.run();
//        System.out.println("======================================");
//        runnable2.run();


//        Arrays.sort(atp, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1.compareTo(o2));
//            }
//        });

        Arrays.sort(atp);

        for (int i=0;i<atp.length;i++)
        {
            System.out.println(atp[i]+" ");
        }

    }
}
