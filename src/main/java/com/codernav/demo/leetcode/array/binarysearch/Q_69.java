package com.codernav.demo.leetcode.array.binarysearch;

/**
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根。
 * 由于返回类型是整数，结果只保留整数部分，小数部分将被舍去
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_69 {
    public static void main(String[] args) {

        int result = f(17);
        System.out.println(result);

        int result1 = f1(17);
        System.out.println(result1);


    }

    private static int f1(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return mid;
            }
            if (mid * mid > x) {
                right = mid - 1;
            }
            if ((mid + 1) * (mid + 1) <= x) {
                left = mid + 1;
            }
        }

        return 1;

    }

    private static int f(int num) {
        // x*x<num*num (x+1)(x+1)>num*num
        for (long i = 1; i <= num; i++) {
            if (i * i <= num && (i + 1) * (i + 1) > num) {
                return (int) i;
            }
        }

        return 0;
    }
}
