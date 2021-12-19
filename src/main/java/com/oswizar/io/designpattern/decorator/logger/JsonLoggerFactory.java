package com.oswizar.io.designpattern.decorator.logger;

import org.slf4j.LoggerFactory;

public class JsonLoggerFactory {

    public static JsonLogger getLogger(Class clazz) {
        return new JsonLogger(LoggerFactory.getLogger(clazz));
    }
}
