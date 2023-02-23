package com.codernav.demo.leetcode.array.minsubarraylen;

/**
 * 209. 长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数target。
 * 找出该数组中满足其和 ≥ target的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr]，并返回其长度。如果不存在符合条件的子数组，返回0。
 * 原文地址：https://www.codernav.com/2910.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_209_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        // 滑动窗口
        System.out.println(f(nums, 5));
    }

    private static int f(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }
}
