package com.codernav.demo.hwod;

import java.util.Arrays;

/**
 * 两数之和（二分查找）
 * 给定一个升序排列的整数数组numbers，从数组中找出两个数满足相加之和等于目标数target。
 * 假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
 * 返回两数的下标值，以数组形式返回。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest24 {
    public static void main(String[] args) {
        int[] result = f(new int[]{1, 2, 3, 4, 5, 6}, 10);
        System.out.println(Arrays.toString(result));
    }

    private static int[] f(int[] nums, int target) {
        // 遍历数组, x+y=target, 每次循环中nums[i]相当于x, y=target-x
        for (int i = 0; i < nums.length; i++) {
            // 使用二分法查找y
            int left = i;
            int right = nums.length - 1;
            // 循环结束条件，左右标记重合
            while (left <= right) {
                // 中间元素的下标
                int mid = left + (right - left) / 2;
                if (nums[mid] == target - nums[i]) { // 中间元素就是要找的y
                    return new int[]{i, mid};
                } else if (nums[mid] > target - nums[i]) { // y在mid的左侧, right左移
                    right = mid - 1;
                } else { // y在mid的右侧，left右移
                    left = mid + 1;
                }
            }
        }

        return new int[0];
    }
}
