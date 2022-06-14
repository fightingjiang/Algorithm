package com.hnu.jiang;

import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {Login.class};
        ClientLogin clientLogin = new ClientLogin();
        Login proxyLogin = (Login)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new ClientLoginProxy(clientLogin));
        proxyLogin.login();
        proxyLogin.out();
    }
}
