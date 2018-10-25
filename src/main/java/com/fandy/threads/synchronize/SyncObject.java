package com.fandy.threads.synchronize;

/**
 * @author: fandy
 * @date: 2018/10/25
 * @description:
 */
public class SyncObject {
    class Account {
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

    class AccountOperator implements Runnable {
        private Account account;

        public AccountOperator(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            synchronized (account) {
                account.deposit(500);
                account.withdraw(500);
                System.out.println(Thread.currentThread() + ":" + account.getBalance());
            }
        }
    }

}
