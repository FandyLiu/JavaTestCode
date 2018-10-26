package com.fandy.threads.synchronize;

import org.junit.Test;

/**
 * @author: fandy
 * @date: 2018/10/26
 * @description:
 */
public class SyncStaticMethodTest {

    @Test
    public void test1() throws InterruptedException {
        SyncStaticMethod syncThread1 = new SyncStaticMethod();
        SyncStaticMethod syncThread2 = new SyncStaticMethod();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
