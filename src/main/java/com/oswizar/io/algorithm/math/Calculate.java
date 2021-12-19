package com.oswizar.io.algorithm.math;

import org.junit.Test;

public class Calculate {

    @Test
    public void print() {
        System.out.println(Math.pow(2, 3));
//        double[] doubles = calculateLoanAmount1(50000, 0.045, 12);
        double amount = calculateLoanAmount2(50000, 0.045, 12);
//        System.out.println(Arrays.toString(doubles));
//        System.out.println(Arrays.stream(doubles).sum());
        System.out.println(amount);

    }

    // 计算等额本金
    public double[] calculateLoanAmount1(double amount, double rate, int period) {
        double[] result = new double[period];
        double equal = amount / period;
        for (int i = 0; i < period; i++) {
            result[i] = (double) (Math.round((amount * (rate / 12) + equal) * 100)) / 100;
            amount = amount - equal;
        }
        return result;

    }

    // 计算等额本息
    public double calculateLoanAmount2(double amount, double rate, int period) {
        double result =
                (double) Math.round(((amount * rate / 12 * Math.pow(1 + rate / 12, period)) / (Math.pow(1 + rate / 12,
                        period) - 1)) * 100) / 100;
        return result;
    }
}
