package com.fandy.threads.synchronize;

import java.util.Date;

/**
 * @author: fandy
 * @date: 2018/10/26
 * @description:
 */
public class SyncClass {

    private static int count = 0;

    public void countAdd() {
        synchronized (SyncClass.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("time " + new Date().getTime() + "-----" + Thread.currentThread()+ ":" + (count++));
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

    // A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
    //B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
    //C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
}
