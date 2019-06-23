package com.chapter1.foundation.deadLock;
//死锁
public class DeadLockTest {
  private static Object resourceA = new Object();
  private static Object resourceB = new Object();
  public static void main(String[] args) {
      Thread threadA = new Thread(new Runnable() {
          public void run() {
              synchronized (resourceA){
                  System.out.println("threadA get resourceA");
                  try {
                      Thread.sleep(1000);
                  }catch (Exception e){
                  }
                  System.out.println("threadA is waiting resourceB");
                  synchronized (resourceB){
                      System.out.println("threadB get resourceB");
                  }
              }
          }
      });
      Thread threadB = new Thread(new Runnable() {
          public void run() {
              synchronized (resourceB){
                  System.out.println("threadB get resourceB");
                  try{
                      Thread.sleep(1000);
                  }catch (Exception e){

                  }
                  System.out.println("threadB is waiting resourceA");
                  synchronized (resourceA){
                      System.out.println("threadB get resourceA");
                  }
              }
          }
      });
      threadA.start();
      threadB.start();
  }
}
