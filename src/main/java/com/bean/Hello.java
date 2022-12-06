package com.bean;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/1 9:59
 */
public class Hello {
    static {
        System.out.println("hello");
    }
    private String name;
    public Hello(){
        this.name="ColorXJH";
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
