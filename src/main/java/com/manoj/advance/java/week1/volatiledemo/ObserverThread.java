package com.manoj.advance.java.week1.volatiledemo;

public class ObserverThread extends Thread{
    public ObserverThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread " + Thread.currentThread().getPriority());
        int value = VolatileDemo.SHARED_INT_VALUE;
        while (value < 10){
            if(value != VolatileDemo.SHARED_INT_VALUE){
                System.out.println("Value got changed, new Value is : " + VolatileDemo.SHARED_INT_VALUE );
                value = VolatileDemo.SHARED_INT_VALUE;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
