package com.codernav.demo.hwod;

import java.util.Arrays;

/**
 * 三个数的最大乘积
 * 一个整型数组 nums ，在数组中找出由三个数字组成的最大乘积，并输出这个乘积。
 * 注意：乘积不会越界。
 * 重点考察：线性扫描
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest20 {
    public static void main(String[] args) {
        int num = f(new int[]{-4, -3, -2, 1, 4, 7, 9});
        System.out.println(num);
        int num1 = f(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(num1);
    }

    private static int f(int[] nums) {
        // 按从小到大排序
        Arrays.sort(nums);

        int n = nums.length;

        // 如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积
        // 如果数组中全是非正数，则最大的三个数相乘同样也为最大乘积
        int num1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // 如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积。
        int num2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(num1, num2);
    }
}
