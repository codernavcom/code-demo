package com.codernav.demo.hwod;

import java.util.Arrays;

/**
 * 两数之和（双指针算法）
 * 给定一个升序排列的整数数组numbers，从数组中找出两个数满足相加之和等于目标数target。
 * 假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
 * 返回两数的下标值，以数组形式返回。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest25 {
    public static void main(String[] args) {
        // for循环
        int[] result = f(new int[]{1, 2, 3, 4, 5, 6}, 10);
        System.out.println(Arrays.toString(result));
        // while循环
        int[] result1 = f1(new int[]{1, 2, 3, 4, 5, 6}, 10);
        System.out.println(Arrays.toString(result1));
    }

    private static int[] f(int[] nums, int target) {
        // 左指针
        int left = 0;
        // 右指针
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[left] + nums[right] == target) { // 左右两指针对应元素值之和等于target，就是我们要找的结果
                return new int[]{left, right};
            } else if (nums[left] + nums[right] < target) { // 左右两指针对应元素之和小于target，只能将left右移，才能把和增加
                left++;
            } else { // 左右两指针对应元素之和大于target，只能将right左移，才能把和减小
                right--;
            }
        }


        return new int[0];
    }

    private static int[] f1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
