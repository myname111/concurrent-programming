package com.chapter3.random;

import java.util.Random;

/**
 * 不同的Random实例,使用相同的种子,生成相同个数的随机数
 * 这些随机数列完全一致
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i=0;i<2;i++){
            Random random = new Random(20);
            for(int j=0;j<5;j++){
                System.out.print(random.nextInt(200)+",");
            }
            System.out.println();
        }
    }
}
