package com.codernav.demo.leetcode.array.removeelement;

import java.util.Arrays;

/**
 * 977. 有序数组的平方（暴力）
 * 给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 原文地址：https://www.codernav.com/2892.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_977 {
    public static void main(String[] args) {
        int[] result = f(new int[]{-4, -1, 0, 3, 10});
        // 0,1,9,16,100
        System.out.println(Arrays.toString(result));
    }

    private static int[] f(int[] nums) {
        // 数组每个元素都改为其平方值
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        // 排序
        Arrays.sort(nums);

        return nums;
    }
}
