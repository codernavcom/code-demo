package com.codernav.demo.leetcode.array.removeelement;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 原文地址：https://www.codernav.com/2907.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_977_1 {
    public static void main(String[] args) {
        int[] result = f(new int[]{-4, -1, 0, 3, 10});
        // 0,1,9,16,100
        System.out.println(Arrays.toString(result));
    }

    private static int[] f(int[] nums) {
        // 定义左指针
        int left = 0;
        // 定义右指针
        int right = nums.length - 1;
        // 定义一个新数组，用来存放元素平方值
        int[] result = new int[nums.length];
        // 定义一个下标，指向新数组最后一个元素位置
        int index = result.length - 1;
        while (left <= right) {
            // 最左边元素平方比最右边元素平方大，取最左边元素平方值
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                index--;
                // 取了left，下次就不取这个值了，所以left++
                left++;
            } else { // 最右边元素平方比最左边元素平方大，取最右边元素平方值
                result[index] = nums[right] * nums[right];
                index--;
                // 取了right，下次就不取这个值了，所以right++
                right--;
            }
        }

        return result;

    }
}
