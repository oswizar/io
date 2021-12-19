package com.oswizar.io.interview.oop;

public class Bicycle implements Car, Runnable {

    public int id;

    public int getId() {
        return id;
    }

    public String start;

    public String end;

    public int speed;

    public int distance;

    public void setDistance(int distance) {
        this.distance = distance;
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

    public Bicycle(int id, String start, String end, int speed) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.speed = speed;
    }

    @Override
    public void move() {
        for (int i = 0; i < this.distance; i++) {
            try {
//                System.out.println(this.getId() + "小黄车走了" + i + "格");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        System.out.println(this.getId() + "小黄车还车");
        MoveTest.stationMap.get(this.getEnd()).bicycleCount++;
    }

    @Override
    public void run() {
        move();
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", speed=" + speed +
                ", distance=" + distance +
                '}';
    }
}
