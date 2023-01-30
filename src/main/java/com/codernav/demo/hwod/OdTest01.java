package com.codernav.demo.hwod;

/**
 * 青蛙跳台阶
 * 问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 原文地址：https://www.codernav.com/2802.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest01 {
    public static void main(String[] args) {
        // 递归法
        System.out.println(f(10));
        // 动态规划法
        System.out.println(f1(10));
    }

    /**
     * 递归法
     * 跳第n个台阶，只能从第n-1个台阶和第n-2个台阶跳，所以f(n)=f(n-1)+f(n-2)
     */
    private static int f(int n) {
        if (n <= 2) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }

    /**
     * 动态规划法 Dynamic Programming，DP
     */
    private static int f1(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        // 动态规划一定要寻找对初始值，假设不设置dp[2]，打印出的值就是错的
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
