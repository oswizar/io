package com.oswizar.io.designpattern.decorator.logger;

import org.slf4j.Logger;

public class LoggerTest {

    private static final Logger logger = JsonLoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.error("系统错误");
        logger.info("系统错误");

    }
}
