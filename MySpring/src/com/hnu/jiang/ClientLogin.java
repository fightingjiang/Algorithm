package com.hnu.jiang;

import org.springframework.stereotype.Component;

@Component
public class ClientLogin implements Login{

    @Override
    public void login() {
        System.out.println("login...");
    }

    @Override
    public void out() {
        System.out.println("out...");
    }
}
