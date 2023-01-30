package com.codernav.demo.leetcode.array.binarysearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_34_1 {
    public static void main(String[] args) {
        // 二分.查找
        int[] result = f(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        int[] result = f(new int[]{1}, 1);
        System.out.println(Arrays.toString(result));
    }

    private static int[] f(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 左边界
        int left = findBorder(nums, target, true);
        // 右边界
        int right = findBorder(nums, target, false);
        return new int[]{left, right};
    }

    private static int findBorder(int[] nums, int target, boolean flag) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                // true找左边界 false找右边界
                if (flag) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }
}
