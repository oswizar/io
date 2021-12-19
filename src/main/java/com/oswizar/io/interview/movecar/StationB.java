package com.oswizar.io.interview.movecar;

public class StationB implements IStation{

    public static int carCount = 40;

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
