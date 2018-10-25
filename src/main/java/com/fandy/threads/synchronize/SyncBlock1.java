package com.fandy.threads.synchronize;

import java.util.Date;
import java.util.concurrent.locks.Lock;

/**
 * @author: fandy
 * @date: 2018/10/25
 * @description:
 */
public class SyncBlock1 implements Runnable  {

    private static int count = 0;

    public void countAdd() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("time" + new Date().getTime() + "-----" + Thread.currentThread()+ ":" + (count++));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        countAdd();
    }

}
