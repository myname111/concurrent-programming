package com.chapter1.foundation.join;

public class JoinInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        final Thread threadOne = new Thread(new Runnable() {
            public void run() {
                System.out.println("threadOne begin...");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadOne end");
            }
        });
        final Thread mainThread = Thread.currentThread();
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                System.out.println("threadTwo begin...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
                System.out.println("threadTwo end");
            }
        });
        threadOne.start();
        threadTwo.start();

        threadOne.join();
        System.out.println("主线程运行结束....");
    }
}
