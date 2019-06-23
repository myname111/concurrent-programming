package com.chapter1.foundation.interrupt;

public class InterruptedTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(!Thread.currentThread().interrupted()){
                    System.out.println("haha");
                }
                System.out.println("调用interrupted()方法后的中断标志："+Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        Thread.sleep(200);
        System.out.println("main thread will interrupt thread");
        thread.interrupt();
        thread.join();
        System.out.println("main thread is over");
    }
}
