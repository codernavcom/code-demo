package com.codernav.demo.hwod;

import java.util.Arrays;

/**
 * 三角形的最大周长（贪心算法）
 * 给定由一些正数（代表长度）组成的数组nums，返回由其中三个长度组成的、面积不为零的三角形的最大周长。如果不能形成任何面积不为零的三角形，返回 0。
 * 原文地址：https://www.codernav.com/2853.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest35 {
    public static void main(String[] args) {
        // 贪心算法
        int result = f(new int[]{3, 6, 2, 3});
        System.out.println(result);
    }

    private static int f(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 倒叙遍历
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
