package com.chapter1.foundation.daemonAndUser;
//守护线程和用户线程的区别
public class DaemonAndUserTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
               while(true){

               }
            }
        });
        //把thread设置为守护线程
        thread.setDaemon(true);
        //启动线程
        thread.start();
        System.out.println("main is over");
    }
}
