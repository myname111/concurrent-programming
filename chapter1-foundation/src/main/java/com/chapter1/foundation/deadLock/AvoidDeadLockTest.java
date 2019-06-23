package com.chapter1.foundation.deadLock;
//避免死锁：多个线程获取资源的顺序一致
public class AvoidDeadLockTest {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA  = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadA get resourceA");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    System.out.println("threadA is waitting resourceB");
                    synchronized (resourceB){
                        System.out.println("threadA get resourceB");
                    }
                }
            }
        });
        Thread threadB  = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadB get resourceA");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    System.out.println("threadB is waitting resourceB");
                    synchronized (resourceB){
                        System.out.println("threadB get resourceB");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
