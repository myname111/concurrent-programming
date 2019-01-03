package com.chapter1.foundation.waitNotify;
/*
一个线程可以获取多个共享变量的锁,当前线程调用当前共享变量的wait()方法,只会释放当前共享变量的锁,而不会释放其他共享变量的锁
 */
public class MultiLock {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try{
                    synchronized (resourceA){
                        System.out.println("threadA get resourceA lock");
                        synchronized (resourceB){
                            System.out.println("threadA get resourceB lock");
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                try{
                    synchronized (resourceA){
                        System.out.println("threadB get resourceA lock");
                        synchronized (resourceB){
                            System.out.println("threadB get resourceB lock");
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(1000);
        threadB.start();
        //等待两个线程结束
        threadA.join();
        threadB.join();
        System.out.println("main over....");
    }
}
