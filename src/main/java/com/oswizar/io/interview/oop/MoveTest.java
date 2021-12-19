package com.oswizar.io.interview.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MoveTest {

    public static Random random = new Random();
    public static Map<String, Integer> distanceMap = new HashMap<>();

    public static int struckCount = 0;

    static {
        distanceMap.put("AB", 14);
        distanceMap.put("AC", 5);
        distanceMap.put("BA", 14);
        distanceMap.put("BC", 9);
        distanceMap.put("CA", 5);
        distanceMap.put("CB", 9);
    }

    public static Map<String, Station> stationMap = new HashMap<>();


    public static String locations = "ABC";

    public static void main(String[] args) throws InterruptedException {


        double a =  2.0;
        double b = a/0;

        Station stationA = new Station("A", 30);
        Station stationB = new Station("B", 40);
        Station stationC = new Station("C", 30);

        {
            stationMap.put("A", stationA);
            stationMap.put("B", stationB);
            stationMap.put("C", stationC);
        }


        // 计时器
        int time = 0;

        System.out.println("第 " + time++ + " 秒："
                + "A站车：" + stationA.bicycleCount + ",-----"
                + "B站车：" + stationB.bicycleCount + ",-----"
                + "C站车：" + stationC.bicycleCount + ",-----"
                + "路上车：" + 0);

        while (true) {


            Thread.sleep(1000);

            Bicycle bicycle = new Bicycle(getRandomId(), getLocation(), getLocation(), 1);

            if (!bicycle.getStart().equals(bicycle.getEnd())) {
                bicycle.setDistance(distanceMap.get(bicycle.getStart() + bicycle.getEnd()));
                stationMap.get(bicycle.getStart()).bicycleCount--;
//                System.out.println("乘客骑走小黄车：" + bicycle);
                Thread thread = new Thread(bicycle);
                thread.start();
//                thread.join();
//                stationMap.get(bicycle.getEnd()).bicycleCount++;
            }


            for (int j = 0; j < 2; j++) {
                Truck truck = null;
                if (stationA.bicycleCount > 30 && struckCount < 2) {
                    truck = new Truck(getRandomId(), stationA.getLocation(), getLocation(), 3, 1);

                } else if (stationB.bicycleCount > 40 && struckCount < 2) {
                    truck = new Truck(getRandomId(), stationB.getLocation(), getLocation(), 3, 1);

                } else if (stationC.bicycleCount > 30 && struckCount < 2) {
                    truck = new Truck(getRandomId(), stationC.getLocation(), getLocation(), 3, 1);
                }

                if (truck != null && !truck.getStart().equals(truck.getEnd())) {
                    truck.setDistance(distanceMap.get(truck.getStart() + truck.getEnd()));
                    stationMap.get(truck.getStart()).bicycleCount--;
//                    System.out.println("货车运走小黄车：" + truck);
                    Thread thread = new Thread(truck);
                    thread.start();
                    struckCount++;
                }
            }


            Thread.yield();
            System.out.println("第 " + time++ + " 秒："
                    + "A站车：" + stationA.bicycleCount + ",-----"
                    + "B站车：" + stationB.bicycleCount + ",-----"
                    + "C站车：" + stationC.bicycleCount + ",-----"
                    + "路上车：" + (100 - (stationA.bicycleCount + stationB.bicycleCount + stationC.bicycleCount)));
        }


    }

    private static String getLocation() {
        return String.valueOf(locations.charAt(random.nextInt(3)));
    }


    private static int getRandomId() {
        return random.nextInt(Integer.MAX_VALUE);
    }
}
