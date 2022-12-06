package com.thread;

import com.company.Main;
import sun.misc.Unsafe;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/1 16:12
 */
public class Test {
    public static void main(String[] args) {
        //Unsafe unsafe= Main.reflectGetUnsafe();
        ChangeThread changeThread = new ChangeThread();
        new Thread(changeThread).start();
        while (true) {
            boolean flag = changeThread.isFlag();
            //unsafe.loadFence(); //加入读内存屏障
            if (flag){
                System.out.println("detected flag changed");
                break;
            }
        }
        System.out.println("main thread end");
    }
}
