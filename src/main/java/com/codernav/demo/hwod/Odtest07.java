package com.codernav.demo.hwod;

/**
 * 埃氏筛选法统计素数个数
 * 利用合数的概念(非素数)，素数*n必然是合数，因此可以从2开始遍历，将所有的合数做上标记
 * 原文地址：https://www.codernav.com/
 */
public class Odtest07 {
    public static void main(String[] args) {
        int count = eratosthenes(100);
        System.out.println(count);
    }

    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n];//false代表素数
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                ans += 1;
                for (int j = i * i; j < n; j += i) {//j就是合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return ans;
    }
}
