package com.thread;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/1 16:13
 */
public class ChangeThread implements Runnable{
    /*volatile*/ boolean flag=false;
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("subThread change flag to:"+flag);
        flag=true;
    }

    public boolean isFlag() {
        return flag;
    }
}
