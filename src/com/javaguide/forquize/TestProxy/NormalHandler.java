package com.javaguide.forquize.TestProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author EDZ
 * @description MyProxy
 * @date 2020/9/22 15:26
 */
public class NormalHandler implements InvocationHandler {

    private Object obj;

    public NormalHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("man say invoked at : " + System.currentTimeMillis());
        method.invoke(obj, args);
        return null;
    }
}
