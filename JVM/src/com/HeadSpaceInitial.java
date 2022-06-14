package com;

import java.util.ArrayList;
import java.util.Random;

public class HeadSpaceInitial {
    Byte[] buffer = new Byte[new Random().nextInt(1024 * 1024)];
    public static void main(String[] args) {
        ArrayList<HeadSpaceInitial> list = new ArrayList<>();
        while (true){
            list.add(new HeadSpaceInitial());
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
