package com.chapter1.foundation.sleep;

public class SleepInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("threadOne 开始睡眠");
                    Thread.sleep(5000);
                    System.out.println("threadOne 结束睡眠");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动threadOne
        threadOne.start();
        //主线程睡眠1s
        Thread.sleep(1000);
        //主线程中断threadOne
        threadOne.interrupt();
    }
}
