package com.codernav.demo.hwod;

/**
 * 最长连续递增序列（贪心算法）
 * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
 * 原文地址：https://www.codernav.com/2845.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest33 {
    public static void main(String[] args) {
        // 贪心算法
        int length = f(new int[]{1, 2, 3, 2, 3, 4, 3, 4, 5, 6, 7});
        System.out.println(length);
    }

    private static int f(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // 记录长度
        int length = 0;
        // 开始下标
        int start = 0;
        // 通过i来计数
        for (int i = 1; i < nums.length; i++) {
            // 如果元素小于等于前一个元素，递增区间终止
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            // 区间长度的计算公式：i-start+1
            length = Math.max(length, i - start + 1);
        }
        return length;
    }
}
