package com.codernav.demo.hwod;

import java.util.Arrays;

/**
 * 724. 寻找数组的中心下标
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 原文地址：https://www.codernav.com/2788.html
 * https://leetcode.cn/problems/find-pivot-index/
 */
public class Odtest10 {
    public static void main(String[] args) {
        int index = f(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(index);
    }

    /**
     * 1、先统计出整个数组的总和，然后从第一个元素开始叠加
     * 2、总和递减当前元素，叠加递增当前元素，知道两个值相等
     */
    private static int f(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum + nums[i] == total - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
