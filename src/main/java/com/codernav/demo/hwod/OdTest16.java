package com.codernav.demo.hwod;

/**
 * x的平方根（二分查找）
 * 问题描述：在不使用 sqrt(x) 函数的情况下，得到 x的平方根的整数部分。
 * 重点考察：二分法、牛顿迭代
 * 原文地址：https://www.codernav.com/2788.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest16 {
    public static void main(String[] args) {
        int num = f(24);
        System.out.println(num);
    }

    /**
     * 分析：x的平方根肯定在0到x之间，使用二分查找定位该数字，该数字的平方一定是最接近x的，m平方值如果
     * 大于x、则往左边找，如果小于等于x则往右边找
     */
    private static int f(int x) {
        int index = -1;
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
}
