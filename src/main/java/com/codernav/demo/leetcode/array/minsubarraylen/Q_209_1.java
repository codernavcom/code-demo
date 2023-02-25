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
        System.out.println(f1(nums, 5));
    }

    // 滑动窗口1
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

    /**
     * 滑动窗口模板：求最小值
     * 1、初始化 left，right，result，bestResult
     * 2、while("右指针没有到结尾"){
     *    3、窗口扩大，加入right对应元素，更新当前result
     *     while("result不满足要求"){
     *        4、窗口缩小，移除left对应元素，left右移
     *     }
     *     5、更新最优结果bestResult
     *     right++;
     * }
     */
    private static int f1(int[] nums, int target) {
        // 定义4个值 两个指针 最优值 计算结果
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        // 右指针没有到达结尾
        while (right < nums.length) {
            // 计算值
            sum = sum + nums[right];
            // 满足条件
            while (sum >= target) {
                // 更新最优结果
                minLength = Math.min(minLength, right - left + 1);
                // 移除left对应元素
                sum = sum - nums[left];
                // 缩小窗口
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
