package com.manoj.advance.java.week1.deadlockDemo;

public class DeadlockDemo {

    private static Integer VALUE = 5;
    private static Integer MULTIPLIER = 1;
    public static void main(String[] args) {

        Runnable task1 = () -> {
            for(; MULTIPLIER < 10 ; MULTIPLIER++)
          synchronized (MULTIPLIER){
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println(Thread.currentThread().getName() + " - " + "Got lock on MULTIPLIER");
              synchronized (VALUE){
                  int factor = VALUE * MULTIPLIER;
                  String log = String.format("%d *  %d = ", VALUE ,MULTIPLIER );
                  System.out.println(log + factor);
              }
          }
        };

        Runnable task2 = () -> {
            for(; MULTIPLIER < 10 ; MULTIPLIER++)
                synchronized (VALUE){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " - " + "Got lock on VALUE");
                    synchronized (MULTIPLIER){
                        int factor = VALUE * MULTIPLIER;
                        String log = String.format("%d *  %d = ", VALUE ,MULTIPLIER );
                        System.out.println(log + factor);
                    }
                }
        };

        Thread thread1 = new Thread(task1);
        thread1.start();


        Thread thread2 = new Thread(task2);
        thread2.start();

    }
}
