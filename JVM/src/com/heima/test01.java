package com.heima;

import java.util.ArrayList;

public class test01 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new student());
        }
        Thread.sleep(10000000);
    }
}
class student{
    private byte[] array = new byte[1024*1024*10];
}