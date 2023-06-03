package com.oswizar.io.designpattern.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.Controller;

public class LazyDCLSingleton {

    private static volatile LazyDCLSingleton instance;

    private LazyDCLSingleton() {
    }

    public static LazyDCLSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDCLSingleton.class) {
                if (instance == null) {
                    instance = new LazyDCLSingleton();
                }
            }
        }

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        return instance;


    }
}
