package com.oswizar.io.interview.movecar;

import java.util.Random;

public class MoveCarTest {

    public static void main(String[] args) throws InterruptedException {

        CarFactory carFactory = new CarFactory();

        IStation stationA = carFactory.getCar(StationA.class);
        IStation stationB = carFactory.getCar(StationB.class);
        IStation stationC = carFactory.getCar(StationC.class);

        int carCount = 0;
        int time = 0;

        Random random = new Random();


        while (true) {

            int index = random.nextInt(3);
            System.out.println(index);

            if (index == 0 && stationA.getCar()) {
                carCount++;
            } else if (index == 1 && stationB.getCar()) {
                carCount++;
            } else if (stationC.getCar()) {
                carCount++;
            }

//            Thread.sleep(1000);

            System.out.println("第 " + ++time + "秒："
                    + "A站车：" + StationA.carCount + ","
                    + "B站车：" + StationB.carCount + ","
                    + "C站车：" + StationC.carCount + ","
                    + "路上车：" + carCount);
        }

    }
}
