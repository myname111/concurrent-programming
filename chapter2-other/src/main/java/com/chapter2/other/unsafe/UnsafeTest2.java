package com.chapter2.other.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest2 {
    private static  Unsafe unsafe;
    private static long longOffset;
    private volatile long num;
    static{
        try{
            //通过反射获取Unsafe类的theUnsafe字段的字段信息
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置该字段可见
            field.setAccessible(true);
            //获取字段值
            unsafe = (Unsafe) field.get(null);
            longOffset = unsafe.objectFieldOffset(UnsafeTest2.class.getDeclaredField("num"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeTest2 test = new UnsafeTest2();
        boolean b = unsafe.compareAndSwapLong(test, longOffset, 0, 1);
        System.out.println(b);
    }
}
