package com.fandy.threads.synchronize;

/**
 * @author: fandy
 * @date: 2018/10/26
 * @description:
 */
public class SyncStaticMethod implements  Runnable{
    private static int count = 0;

    public synchronized static void method() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        method();
    }
}
