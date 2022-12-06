package com.company;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/1 11:14
 */
public class MyMethodHandler implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before cglib method===");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("after cglib method===");
        return o1;


    }
}
