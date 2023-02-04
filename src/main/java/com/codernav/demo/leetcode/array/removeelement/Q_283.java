package com.codernav.demo.leetcode.array.removeelement;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_283 {
    public static void main(String[] args) {
        f(new int[]{0, 1, 0, 3, 12});
    }

    private static void f(int[] nums) {

        // 第一次遍历，得到数组[1,3,12,3,12]，及slow值
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // 第二次遍历，将slow后面的元素置为0
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.println("slow:" + slow + ", nums:" + Arrays.toString(nums));
    }
}
