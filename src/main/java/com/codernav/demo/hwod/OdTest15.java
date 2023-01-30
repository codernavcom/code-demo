package com.codernav.demo.hwod;

/**
 * x的平方根（暴力算法）
 * 问题描述：在不使用 sqrt(x) 函数的情况下，得到 x的平方根的整数部分。
 * 重点考察：二分法、牛顿迭代
 * 原文地址：https://www.codernav.com/2788.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest15 {
    public static void main(String[] args) {
        int num = f(24);
        System.out.println(num);
    }

    /**
     * 分析：x的整数部分(i)一定存在以下关系式
     * i的平方 <= x 且 i+1的平方 > x
     */
    public static int f(int x) {
        for (int i = 1; i < x + 1; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }

        return 1;
    }
}
