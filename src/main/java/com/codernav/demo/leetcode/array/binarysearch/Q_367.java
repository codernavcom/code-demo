package com.codernav.demo.leetcode.array.binarysearch;

/**
 * 367. 有效的完全平方数
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_367 {
    public static void main(String[] args) {
        // 注意int类型超时
        boolean result = f(2147483647);
        System.out.println(result);

    }

    private static boolean f(int x) {
        long left = 1;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            // 上面为什么要定义成long，而不是int，因为int会超出int范围，执行用例时会超时
            if (mid * mid == x) {
                return true;
            }
            if (mid * mid <= x) {
                left = mid + 1;
            }
            if (mid * mid > x) {
                right = mid - 1;
            }
        }

        return Boolean.FALSE;

    }

}
