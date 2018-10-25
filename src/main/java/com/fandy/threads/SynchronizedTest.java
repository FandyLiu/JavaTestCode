package com.fandy.threads;

/**
 * @Description
 * @Author fandy
 * @Date 2018/10/25 10:32 AM
 * @Version 1.0
 */
public class SynchronizedTest {
    class SyncBlockTest implements Runnable {
        private static int count = 0;
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread()+ ":" + (count++));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

    }

}
