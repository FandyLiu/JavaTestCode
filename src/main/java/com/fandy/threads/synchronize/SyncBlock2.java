package com.fandy.threads.synchronize;

import java.util.Date;

/**
 * @author: fandy
 * @date: 2018/10/25
 * @description:
 */
public class SyncBlock2 implements Runnable  {

    private static int count = 0;


    public void printCount() {
        for (int i = 0; i< 10; i++) {
            System.out.println("time" + new Date().getTime() + "-----" + Thread.currentThread()+ " printCount :" + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void countAdd() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("time" + new Date().getTime() + "-----" + Thread.currentThread()+ " countAdd :" + (count++));
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
        String threadName = Thread.currentThread().getName();

        if (threadName.equals("syncBlock1")) {
            countAdd();
        }else if (threadName.equals("syncBlock2")) {
            printCount();
        }
    }
}
