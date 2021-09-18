package com.manoj.advance.java.week1.deadlockDemo;

public class DeadlockDemoUsingJoin {

    private static Integer VALUE = 5;
    private static Integer MULTIPLIER = 1;
    public static void main(String[] args) {

        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName());
            for(; MULTIPLIER <= 10 ; MULTIPLIER++)
          synchronized (MULTIPLIER){
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
//              System.out.println(Thread.currentThread().getName() + " - " + "Got lock on MULTIPLIER");
              synchronized (VALUE){
                  int factor = VALUE * MULTIPLIER;
                  String log = String.format("%d *  %d = ", VALUE ,MULTIPLIER );
                  System.out.println(log + factor);
              }
          }
        };

        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName());
            for(int i = 1 ; i <= 10 ; i++)
                synchronized (VALUE){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    System.out.println(Thread.currentThread().getName() + " - " + "Got lock on VALUE");
                    synchronized (MULTIPLIER){
                        String log = String.format("%d *  %d = ", VALUE ,i );
                        int factor = VALUE * i;
                        System.out.println(log + factor);
                    }
                }
        };

        Thread thread1 = new Thread(task1);
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(task2);
        thread2.start();

    }
}
