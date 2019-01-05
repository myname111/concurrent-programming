package com.chapter1.foundation.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//线程休眠
public class SleepTest {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadOne 开始睡眠...");
                    Thread.sleep(5000);
                    System.out.println("threadOne 结束睡眠");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadTwo 开始睡眠...");
                    Thread.sleep(5000);
                    System.out.println("threadTwo 结束睡眠");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}
