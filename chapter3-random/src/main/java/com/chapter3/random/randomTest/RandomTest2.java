package com.chapter3.random.randomTest;

public class RandomTest2 {
    public static void main(String[] args) {
        System.out.println(method(-2));
        System.out.println(Integer.toBinaryString(-2));
    }
    public static int method(int x){
        int count=0;
        while(x!=0){
            count++;
            x=x&(x-1);
        }
        return count;
    }
}
