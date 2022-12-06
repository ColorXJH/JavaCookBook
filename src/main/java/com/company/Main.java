package com.company;

import com.bean.Hello;
import com.bean.JDKProxyFactory;
import com.bean.MyInterface;
import com.bean.MyInterfaceImpl;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ColorXJH
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
	// write your code here
        Class clazz1= Hello.class;
        //Class clazz2=Class.forName("com.bean.Hello");
        //Hello hello=new Hello();
        //Class clazz3=hello.getClass();
        Class clazz4=ClassLoader.getSystemClassLoader().loadClass("com.bean.Hello");
        Hello hellos=(Hello)clazz4.newInstance();
        Method[] methods=hellos.getClass().getDeclaredMethods();
        for(Method m:methods){
            System.out.println(m.getName());
        }
        System.out.println("--------");
        Method publicMethod=clazz4.getDeclaredMethod("getName",null);
        System.out.println(publicMethod.invoke(hellos,null));

        MyInterface proxy = (MyInterface)JDKProxyFactory.getProxy(new MyInterfaceImpl());
        proxy.sayHello("9999");


        SendMessage sendMessage=(SendMessage)CGLIBProxy.getProxy(SendMessage.class);
        sendMessage.send("java");

        System.out.println("-----");
        Unsafe unsafe=Main.reflectGetUnsafe();
    }



    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}
