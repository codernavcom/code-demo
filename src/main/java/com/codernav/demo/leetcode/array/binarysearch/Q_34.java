package com.codernav.demo.leetcode.array.binarysearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_34 {
    public static void main(String[] args) {
        // 暴力算法
        int[] result = f(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(result));
    }

    private static int[] f(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 正向遍历，找到最左边位置
        int left = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                left = i;
                break;
            } else {
                left = -1;
            }
        }
        // 反向遍历，找到最右边位置
        int right = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                right = i;
                break;
            } else {
                right = -1;
            }
        }

        return new int[]{left, right};
    }
}
