package com.chapter1.foundation.interrupt;

public class InterrupExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("thread begin sleep");
                    Thread.sleep(20000);
                    System.out.println("thread end sleep");
                } catch (InterruptedException e) {
                    System.out.println("中断标志："+Thread.currentThread().isInterrupted());
                    System.out.println("thread is interrupted while sleeping");
                    e.printStackTrace();
                }
                System.out.println("thread is over");
            }
        });
        //线程启动
        thread.start();
        //主线程睡眠1s，以便让thread进入休眠
        thread.sleep(1000);
        System.out.println("main thread will interrupt child thread......");
        //主线程调用thread的interrupt方法设置中断标志
        thread.interrupt();
        //等待thread运行结束
        thread.join();
        System.out.println("main thread is over");
    }
}
