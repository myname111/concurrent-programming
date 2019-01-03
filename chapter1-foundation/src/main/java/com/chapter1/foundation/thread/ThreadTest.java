package com.chapter1.foundation.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//实现线程的三种方式
public class ThreadTest {
    //1.继承Thread类重写run方法
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("线程");
            System.out.println("当前线程:"+this.getName());
        }
    }
    //2.实现Runnable接口,重写run方法
    public static class MyRunnable implements Runnable{
        public void run() {
            System.out.println("当前线程:"+Thread.currentThread().getName());
        }
    }
    //3.实现Callable接口,重写call方法,可以返回执行的结果
    public static class MyCallable implements Callable<String>{
        public String call() throws Exception {
            System.out.println("当前线程:"+Thread.currentThread().getName());
            return "hello world "+Thread.currentThread().getName();
        }
    }
    public static void main(String[] args) {
        //启动线程
        //1.创建MyThread类的对象,调用start方法
        /*MyThread thread = new MyThread();
        thread.start();
        MyThread thread2 = new MyThread();
        thread2.start();*/

        //2.创建Thread类的对象,构造参数是Runnable接口的实现类.调用start方法
       /* MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();*/

        //3.
        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        futureTask = new FutureTask(callable);
        Thread thread2= new Thread(futureTask);
        thread2.start();
        try {
            String result = (String) futureTask.get();
            System.out.println("结果:"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
