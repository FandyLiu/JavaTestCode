package com.fandy.threads.synchronize;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: fandy
 * @date: 2018/10/25
 * @description:
 */
public class SyncBlockTest {



    @Test(expected = InterruptedException.class, timeout = 100)
    public void test1() throws RuntimeException {
        throw new RuntimeException();

//        SyncBlock1 syncBlock = new SyncBlock1();
//        Thread thread1 = new Thread(syncBlock, "syncBlock1");
//        Thread thread2 = new Thread(syncBlock, "syncBlock2");
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
        // 从运行结果可以看出 两个线程是互斥的, thread1 先执行完之后, thread2 才会执行
        // 因为在执行synchronized代码块的时候,会锁定当前对象. 只有代码执行完才会释放该对象的锁
    }

    @Test
    public void test2() throws InterruptedException {
        Thread thread1 = new Thread(new SyncBlock1(), "syncBlock1");
        Thread thread2 = new Thread(new SyncBlock1(), "syncBlock2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        // 这是因为synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
        // 这时会有两把锁分别锁定 syncBlock1 对象和 syncBlock2 对象，而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
    }

    @Test
    public void test3() throws InterruptedException {
        SyncBlock2 syncBlock = new SyncBlock2();
        Thread thread1 = new Thread(syncBlock, "syncBlock1");
        Thread thread2 = new Thread(syncBlock, "syncBlock2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        // 当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。
    }


}
