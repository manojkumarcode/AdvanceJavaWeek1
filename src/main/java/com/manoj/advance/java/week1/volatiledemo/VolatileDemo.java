package com.manoj.advance.java.week1.volatiledemo;

public class VolatileDemo {

    static volatile int SHARED_INT_VALUE = 0;

    public static void main(String[] args) {
        new ObserverThread("OBSERVER").start();
        new ActorThread("ACTOR").start();
        System.out.println("test");
    }
}
