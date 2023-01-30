package com.codernav.demo.hwod;

import java.util.Arrays;

/**
 * 两数之和（双重for循环）
 * 给定一个升序排列的整数数组numbers，从数组中找出两个数满足相加之和等于目标数target。
 * 假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
 * 返回两数的下标值，以数组形式返回。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class Odtest22 {
    public static void main(String[] args) {
        int[] result = f(new int[]{1, 2, 3, 4, 5, 6}, 10);
        System.out.println(Arrays.toString(result));
    }

    private static int[] f(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
