package com.manoj.advance.java.week1.concurrentapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExceptioDemo {
    public static void main(String[] args) {
        List<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("abc");
        arrayList.add("bcd");

        for (String value :arrayList) {
            System.out.println(value);
            arrayList.add("cde");

        }

    }
}
