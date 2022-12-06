package com.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/1 10:34
 */
public class JDKInvokeHandler implements InvocationHandler {
    private final Object target;

    public JDKInvokeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("beforeMethod======"+method.getName());
        Object result=method.invoke(target,args);
        System.out.println("afterMethod======"+method.getName());
        return result;
    }
}
