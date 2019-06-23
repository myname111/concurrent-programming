package com.chapter3.random.randomTest;

import java.util.concurrent.ThreadLocalRandom;

public class ThrreadLocalRandomTest {
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            ThreadLocalRandom current = ThreadLocalRandom.current();
            for (int j=0;j<5;j++){
                System.out.print( current.nextInt()+",");
            }
            System.out.println();
        }
    }
}
