package com.codernav.demo.hwod;

import java.util.Arrays;

/**
 * 寻找数组的中心索引
 * 给定一个整数数组nums，请编写一个能够返回数组“中心下标”的方法
 * 原文地址：https://www.codernav.com/2788.html
 */
public class Odtest10 {
    public static void main(String[] args) {
        int index = f(new int[]{1, 7, 3, 6, 5, 6});
        int index1 = f1(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(index);
        System.out.println(index1);
    }

    /**
     * 1、先统计出整个数组的总和，然后从第一个元素开始叠加
     * 2、总和递减当前元素，叠加递增当前元素，知道两个值相等
     */
    private static int f(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left + nums[i] == total - left) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    public static int f1(int[] nums) {
        int sum1 = Arrays.stream(nums).sum();
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
            if (sum1 == sum2) {
                return i;
            }
            sum1 = sum1 - nums[i];
        }
        return -1;
    }
}
