package com.fandy.threads.synchronize;

import java.util.Date;

/**
 * @author: fandy
 * @date: 2018/10/25
 * @description:
 */
public class SyncObject {
    static class Account {
        private String name;
        private float amount;

        public Account(String name, float amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public float getAmount() {
            return amount;
        }

        // 存钱
        public void deposit(float amount) {
            this.amount += amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 取钱
        public void withdraw(float amount) {
            this.amount -= amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public float getBalance() {
            return amount;
        }
    }

    static class AccountOperator implements Runnable {
        private Account account;

        public AccountOperator(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            synchronized (account) {
                account.deposit(500);
                account.withdraw(500);
                System.out.println("time" + new Date().getTime() + "-----" +Thread.currentThread() + ":" + account.getBalance());
            }
        }
    }

    public static void main(String[] args) {
        SyncObject.Account account = new SyncObject.Account("zhang san", 10000.0f);
        SyncObject.AccountOperator accountOperator = new SyncObject.AccountOperator(account);

        final int THREAD_NUM = 5;
        Thread threads[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i ++) {
            System.out.println("line" + 1 + "-----"+ new Date().getTime() + "-----"+  "thread" + i);
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
            System.out.println("line" + 2 + "-----"+ new Date().getTime() + "-----"+  "thread" + i);
        }
    }
}
