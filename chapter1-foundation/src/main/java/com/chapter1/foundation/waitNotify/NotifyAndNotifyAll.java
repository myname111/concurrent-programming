package com.chapter1.foundation.waitNotify;

public class NotifyAndNotifyAll {
    private static volatile Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try{
                    System.out.println("threadA begin wait");
                    synchronized (resource){
                        resource.wait();
                    }
                    System.out.println("threadA end wait");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                 try {
                     System.out.println("threadB begin wait");
                     synchronized (resource){
                         resource.wait();
                     }
                     System.out.println("threadB end wait");
                 }catch (Exception e){
                     e.printStackTrace();
                 }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            public void run() {
                try{
                    System.out.println("threadC begin notify");
                    synchronized (resource){
                        resource.notify();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        Thread threadD = new Thread(new Runnable() {
            public void run() {
                try{
                    System.out.println("threadD begin notify");
                    synchronized (resource){
                        resource.notifyAll();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        threadA.start();
        threadB.start();
        //Thread.sleep(1000);
        //threadC.start();
        threadD.start();

        //等待线程结束
        threadA.join();
        threadB.join();
        //threadC.join();
        threadD.join();
        System.out.println("main over");
    }
}
