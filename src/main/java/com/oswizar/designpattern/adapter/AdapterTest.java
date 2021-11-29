package com.oswizar.designpattern.adapter;

public class AdapterTest {

    public static void main(String[] args) {
        AC220 ac220V = new AC220();

        DC dc = new PowerAdapter(ac220V);
        dc.output5V();
        dc.output12V();
    }
}
