package com.codernav.demo.hwod;

/**
 * x的平方根（牛顿迭代）
 * 问题描述：在不使用 sqrt(x) 函数的情况下，得到 x的平方根的整数部分。
 * 重点考察：二分法、牛顿迭代
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest17 {
    public static void main(String[] args) {
        System.out.println(newton(6));
    }

    public static int newton(int x) {
        if (x == 0) return 0;
        return ((int) (sqrts(x, x)));
    }

    public static double sqrts(double i, int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrts(res, x);
        }
    }
}
