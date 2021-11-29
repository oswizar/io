package com.oswizar.designpattern.decorator.logger;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

public class JsonLogger extends LoggerDecorator{

    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void error(String msg) {
        JSONObject result = newJsonObject();
        result.put("msg", msg);
        super.error(result.toString());
    }

    @Override
    public void info(String msg) {
        JSONObject result = newJsonObject();
        result.put("msg", msg);
        super.info(result.toString());
    }

//    public void error(Exception e) {
//        JSONObject result = newJsonObject();
//        result.put("exception", e.getClass().getName());
//        result.put("trace", Arrays.toString(e.getStackTrace()));
//        super.logger.error(result.toString());
//    }

    private JSONObject newJsonObject() {
        return new JSONObject();
    }
}
