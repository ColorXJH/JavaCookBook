package com.bean;

import java.lang.reflect.Proxy;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/1 10:45
 */
public class JDKProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new JDKInvokeHandler(target));
    }
}
