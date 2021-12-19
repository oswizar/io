package com.oswizar.io.interview.movecar;

public class CarFactory {

    Class<? extends IStation> clazz;

    public IStation getCar(Class<? extends IStation> clazz) {
        if (clazz == null) {
            return null;
        }
        IStation station = null;
        try {
            station = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return station;

    }
}
