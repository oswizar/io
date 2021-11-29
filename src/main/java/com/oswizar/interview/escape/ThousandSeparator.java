package com.oswizar.interview.escape;

public class ThousandSeparator {

    public static void main(String[] args) {
        String s = new ThousandSeparator().thousandSeparator(1123456789);
        System.out.println(s);
    }

    public String thousandSeparator(int n) {
        StringBuilder s = new StringBuilder(String.valueOf(n));
        // 1.234.567.783
        for (int i = s.length() - 3; i > 0; i -= 3) {
            s.insert(i, ".");
        }
        return s.toString();
    }

//    public String thousandSeparator(int n) {
//        if (0 == n) {
//            return "0";
//        }
//        StringBuilder s = new StringBuilder();
//        // 1.234.567.783
//        int count = 0;
//        while (n != 0) {
//            int i = n % 10;
//            s.append(i);
//            count++;
//            n /= 10;
//            if (n != 0 && count % 3 == 0) {
//                s.append(".");
//            }
//        }
//        return s.reverse().toString();
//    }
}
