package com.codernav.demo.leetcode.array.minsubarraylen;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组（暴力解法）
 * 给定一个含有n个正整数的数组和一个正整数target。
 * 找出该数组中满足其和 ≥ target的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr]，并返回其长度。如果不存在符合条件的子数组，返回0。
 * 原文地址：https://www.codernav.com/2892.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_209 {
    public static void main(String[] args) {
//      sout:2
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(f(nums, 7));
//      sout:2
        int[] nums1 = new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        System.out.println(f(nums1, 15));
//      sout:0
        int[] nums2 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(f(nums2, 11));
    }

    private static int f(int[] nums, int target) {
        // 不满足条件
        if (Arrays.stream(nums).sum() < target) {
            return 0;
        }
        // 最小长度
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 子数组求和，直到找到和大于target的位置
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    // 上一轮长度与本次循环长度比较，取较小的
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        return minLength;
    }
}
