package com.bean;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/1 10:31
 */
public class MyInterfaceImpl implements MyInterface{
    @Override
    public String sayHello(String name) {
        System.out.println("hello- -"+name);
        return name;
    }
}
