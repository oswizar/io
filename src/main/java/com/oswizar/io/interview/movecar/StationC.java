package com.oswizar.io.interview.movecar;

public class StationC implements IStation {

    public static int carCount = 30;

    @Override
    public boolean getCar() {
        if (carCount > 0) {
            carCount--;
            return true;
        } else {
            return false;
        }
    }
}
