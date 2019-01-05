package com.chapter1.foundation.yield;

import sun.awt.windows.ThemeReader;

public class YieldTest implements Runnable {
    public YieldTest(){
        Thread thread = new Thread(this);
        thread.start();
    }
    public void run() {
        for (int i=0;i<5;i++){
            //i=5时当前线程让出CPU执行权
            if (i%5==0){
                System.out.println(Thread.currentThread()+"开始让出CPU...");
                //线程让出CPU执行权
               Thread.yield();
            }
        }
        System.out.println(Thread.currentThread()+"线程运行结束");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
