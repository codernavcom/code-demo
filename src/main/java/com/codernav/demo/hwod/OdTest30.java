package com.codernav.demo.hwod;

/**
 * 子数组最大平均数
 * 给一个整数数组，找出平均数最大且长度为 k 的下标连续的子数组，并输出该最大平均数。
 * 原文地址：https://www.codernav.com/2841.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest30 {
    public static void main(String[] args) {
        // 滑动窗口算法
        double result = f(new int[]{1, 12, -5, -6, 50, 3}, 4);
        System.out.println(result);
    }

    private static double f(int[] nums, int k) {
        int sum = 0;
        // 找到第一个窗口的值
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        // 注意i从k开始遍历
        for (int i = k; i < nums.length; i++) {
            // 减去第一个元素的值，加上当前元素的值
            sum = sum - nums[i - k] + nums[i];
            // 求上次求和与这次求和的最大值
            max = Math.max(sum, max);
        }

        return 1.0 * max / k;

    }
}
