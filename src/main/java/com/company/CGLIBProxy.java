package com.company;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/1 11:16
 */
public class CGLIBProxy {
    public static Object getProxy(Class<?>clazz){
        //创建动态代理增强类
        Enhancer enhancer=new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new MyMethodHandler());
        // 创建代理类
        return enhancer.create();
    }
}
