package com.fandy.threads.synchronize;

import org.junit.Test;

import java.util.Date;

/**
 * @author: fandy
 * @date: 2018/10/25
 * @description:
 */
public class SyncObjectTest {


    @Test
    public void test1() throws InterruptedException {
        SyncObject.Account account = new SyncObject.Account("zhang san", 10000.0f);
        SyncObject.AccountOperator accountOperator = new SyncObject.AccountOperator(account);

        final int THREAD_NUM = 5;
        Thread threads[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i ++) {
            System.out.println("line" + 1 + "-----"+ new Date().getTime() + "-----"+  "thread" + i);
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i ++ ) {
            System.out.println("line" + 2 + "-----"+ new Date().getTime() + "-----"+  "thread" + i);
            threads[i].join();
        }
        //在AccountOperator 类中的run方法里，我们用synchronized 给account对象加了锁。
        // 这时，当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，直到该线程访问account对象结束。也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。

        //当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的对象来充当锁：

    }

    private byte[] lock = new byte[0]; // 特殊的instance变量
    public void method()
    {
        synchronized(lock) {
            // todo 同步代码块
        }
    }
    // 当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的对象来充当锁：
    // 零长度的byte数组对象创建起来将比任何对象都经济――查看编译后的字节码：生成零长度的byte[]对象只需3条操作码，而Object lock = new Object()则需要7行操作码。

}
