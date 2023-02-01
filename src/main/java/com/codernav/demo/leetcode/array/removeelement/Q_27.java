package com.codernav.demo.leetcode.array.removeelement;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_27 {
    public static void main(String[] args) {
        // 数组只能覆盖，不能删除元素
        // 双指针.算法
        int length = f(new int[]{3, 2, 2, 3}, 3);
        System.out.println(length);
    }

    private static int f(int[] nums, int val) {
        // 慢指针 可以看成新数组的元素集合
        int slow = 0;
        // 快指针 可以看成原数组的元素集合
        for (int fast = 0; fast < nums.length; fast++) {
            // 原数组元素不等于给定值时，就把这个元素赋值给新数组，等于给定值就跳过
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                // 慢指针加1
                slow++;
            }
        }
        return slow-1;
    }
}
