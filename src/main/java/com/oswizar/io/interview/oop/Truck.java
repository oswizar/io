package com.oswizar.io.interview.oop;


public class Truck implements Car, Runnable {

    public int id;

    public int getId() {
        return id;
    }

    public String start;

    public String end;

    public int speed;

    public int distance;

    public int bicycleCount;

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getBicycleCount() {
        return bicycleCount;
    }

    public void setBicycleCount(int bicycleCount) {
        this.bicycleCount = bicycleCount;
    }

    public Truck(int id, String start, String end, int speed, int bicycleCount) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.speed = speed;
        this.bicycleCount = bicycleCount;
    }

    @Override
    public void move() {
        for (int i = 0; i < this.distance; i += 3) {
            try {
//                System.out.println(this.getId() + "货车走了" + i + "格");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        System.out.println(this.getId() + "货车到达车站进行补货");
        MoveTest.stationMap.get(this.getEnd()).bicycleCount++;
        MoveTest.struckCount--;
    }

    @Override
    public void run() {
        move();
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", speed=" + speed +
                ", distance=" + distance +
                ", bicycleCount=" + bicycleCount +
                '}';
    }
}
