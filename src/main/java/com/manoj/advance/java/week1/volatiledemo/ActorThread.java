package com.manoj.advance.java.week1.volatiledemo;

public class ActorThread extends Thread{
    public ActorThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread " + Thread.currentThread().getPriority());
        int value = VolatileDemo.SHARED_INT_VALUE;
        while (VolatileDemo.SHARED_INT_VALUE < 10){
            System.out.println("Incrementing value, new value is: " + (value+1));
            VolatileDemo.SHARED_INT_VALUE = ++value;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}