package com.chapter1.foundation.waitNotify;
/*
当一个线程调用共享对象的wait()方法被阻塞挂起后,如果其他线程调用了该线程的interrupt()方法中断了该线程
则该线程会抛出InterruptedException异常并返回,线程终止
 */
public class WaitNotifyInterrupt {
    private static volatile Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    synchronized (object){
                        System.out.println("---begin---");
                        object.wait();
                        System.out.println("---end---");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("begin interrupt thread");
        thread.interrupt();
        System.out.println("end interrupt thread");
    }
}
