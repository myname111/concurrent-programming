package com.chapter1.foundation.interrupt;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                  //当中断标志为false，即线程没有被中断时打印输出
                   while(!Thread.currentThread().isInterrupted()){
                       System.out.println(Thread.currentThread()+" hello");
                   }
                System.out.println("thread 运行结束");
            }
        });
        //启动线程
        thread.start();
        //主线程休眠500ms，以便让thread输出内容
        Thread.sleep(500);
        System.out.println("主线程中断子线程.....");
        //主线程中断thread
        thread.interrupt();
        //等待thread执行完成
        thread.join();
        System.out.println("主线程结束");

    }
}
