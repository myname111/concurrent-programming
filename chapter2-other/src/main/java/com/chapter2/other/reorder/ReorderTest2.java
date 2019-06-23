package com.chapter2.other.reorder;

public class ReorderTest2 {
    private static int num = 0;
    private static boolean flag = false;
    public static class ReadThread extends Thread{
        @Override
        public void run() {
            if (flag){
                System.out.println(num!=0?"":num);
            }
        }
    }
    public static class WriteThread extends Thread{
        @Override
        public void run() {
            num = 1;
            flag = true;
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<=2000;i++) {
            ReadThread readThread = new ReadThread();
            WriteThread writeThread = new WriteThread();
            readThread.start();
            writeThread.start();

            try {
                readThread.join();
                writeThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = 0;
            flag = false;
        }
    }
}
