package com.chapter1.foundation.join;
//当前线程调用其他线程的join方法,当前线程会被阻塞,直到其他线程运行结束,当前线程才会继续运行
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadOne end");
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
               try {
                    Thread.sleep(1000);
              } catch (InterruptedException e) {
                   e.printStackTrace();
               }
                System.out.println("threadTwo end");
            }
        });
        threadOne.start();
        threadTwo.start();

        System.out.println("等待两个线程结束");
        threadOne.join();
        threadTwo.join();
        System.out.println("两个线程结束......");

    }
}
