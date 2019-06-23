package com.chapter2.other.unsafe;

import sun.misc.Unsafe;

/**
 * 获取变量num在UnSafeTest类中的偏移量,并给该变量设置新值.
 */
public class UnSafeTest {
    /**
     * 获取Unsafe实例对象
     */
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    /**
     * 记录变量num在UnSafeTest类中的偏移量
     */
    private static final long longOffset;
    /**
     * 变量num
     */
    private volatile long num;
    static {
        try{
            longOffset = unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("num"));
        }catch(Exception e){
            e.printStackTrace();
            throw new Error();
        }
    }

    public static void main(String[] args) {
        UnSafeTest test = new UnSafeTest();
        // 给变量num设置新值
        boolean success = unsafe.compareAndSwapLong(test, longOffset, 0, 1);
        System.out.println(success);
    }

}
