package com.hnu.jiang;

import org.springframework.stereotype.Component;

@Component
public class TransactionDemo {
    public void before(){
        System.out.println("before...");
    }
}
