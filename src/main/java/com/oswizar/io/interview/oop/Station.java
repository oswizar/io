package com.oswizar.io.interview.oop;

public class Station {

    public String location;

    public int bicycleCount;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBicycleCount() {
        return bicycleCount;
    }

    public void setBicycleCount(int bicycleCount) {
        this.bicycleCount = bicycleCount;
    }

    public Station(String location, int bicycleCount) {
        this.location = location;
        this.bicycleCount = bicycleCount;
    }
}
