package com.codernav.demo.hwod;

/**
 * 三个数的最大乘积
 * 一个整型数组 nums ，在数组中找出由三个数字组成的最大乘积，并输出这个乘积。
 * 注意：乘积不会越界。
 * 重点考察：线性扫描
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest21 {
    public static void main(String[] args) {
        int num = f(new int[]{-4, -3, -2, 1, 4, 7, 9});
        System.out.println(num);
        int num1 = f(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(num1);
    }

    private static int f(int[] nums) {
        // 最小的和第二小的
        int min1 = 0, min2 = 0;
        // 最大的、第二大的和第三大的
        int max1 = 0, max2 = 0, max3 = 0;
        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }


        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

}
