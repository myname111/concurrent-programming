package com.chapter1.foundation.interrupt;

public class InterruptedDiffTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (;;){

                }
            }
        });
        //线程运行
        thread.start();
        //设置中断标志
        thread.interrupt();
        //获取中断标志
        System.out.println("isInterrupted:"+thread.isInterrupted());
        //获取中断标志
        System.out.println("isInterrupted:"+thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted:"+Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted:"+thread.isInterrupted());
    }
}
