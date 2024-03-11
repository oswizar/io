package com.oswizar.io.temp;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SyncTest {

    private final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        boolean a = list.add("a");
        System.out.println(a);

    }

}


class MyThread extends Thread {
    @Override
    public void run(){
        super.run();
        for(int i=0; i<500000; i++){
            if(interrupted()) {
                System.out.println("线程已经终止， for循环不再执行");
                return;
            }
            System.out.println("i="+(i+1));
        }
    }
}

