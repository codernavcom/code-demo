package com.codernav.demo.hwod;

/**
 * 统计N以内的素数
 * 暴力算法、埃氏筛选法
 * 素数：只能被1和自身整除的数，0、1除外
 * 原文地址：https://www.codernav.com/
 */
public class Odtest06 {
    public static void main(String[] args) {
        // 暴力算法
        int count = f(100);
        System.out.println(count);
        // 埃氏筛选法 利用合数的概念(非素数)，素数*n必然是合数，因此可以从2开始遍历，将所有的合数做上标记
        int count1 = eratosthenes(100);
        System.out.println(count1);
    }

    private static int f(int n) {
        int count = 0;
        // 从2开始n-1结束，因为1和n除外，要排除掉
        for (int i = 2; i < n; i++) {
          count += check1(i) ? 1 : 0;
        }
        return count;
    }

    /**
     * 优化暴力算法
     * 实际上，for循环遍历时，j只需要<=根号i即可，降低时间复杂度
     * 举例：12,可以拆解成2x6,3x4,4x3,6x2,只需要判断前两个成立即可，后面两个没必要重复判断
     * j * j <= i 等价于 j <= 根号i
     */
    private static boolean check1(int i) {
        // 如果是素数，返回true，否则返回false
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
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
