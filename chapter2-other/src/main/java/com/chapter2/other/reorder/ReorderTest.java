package com.chapter2.other.reorder;

/**
 * 测试指令重排序
 */
public class ReorderTest {
    private static int num=0;
    private static boolean ready=false;
    public static class ReadThread extends Thread{
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                if (ready){ //(1)
                    System.out.println(num+num);//(2)
                }
                System.out.println("read thread....");
            }

        }
    }
    public static class WriteThread extends Thread{
        @Override
        public void run() {
            num=2;//(3)
            ready=true;//(4)
            System.out.println("write over...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread read = new ReadThread();
        read.start();
        WriteThread writeThread = new WriteThread();
        writeThread.start();

        Thread.sleep(100);
        read.interrupt();
        System.out.println("end...");
    }
}
