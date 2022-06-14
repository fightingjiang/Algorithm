package com.hnu.jiang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClientLoginProxy implements InvocationHandler {
    private Object object;

    public ClientLoginProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName()=="login"){
            System.out.println("before login fun...");
            Object res = method.invoke(object, args);
            System.out.println("after login fun");
            return res;
        }else {
            return method.invoke(object,args);
        }
    }
}

