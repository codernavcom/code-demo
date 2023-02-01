package com.codernav.demo.leetcode.array.removeelement;

import java.util.Arrays;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class Q_26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(f(nums));
        int[] nums1 = new int[]{0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums1));

    }

    private static int f(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length - 1; fast++) {
            System.out.println("slow:" + slow + ", fast:" + fast + ", nums:" + Arrays.toString(nums));
            if (nums[fast] != nums[fast + 1]) {
                slow++;
                nums[slow] = nums[fast + 1];
            }
        }
        return slow + 1;
    }

    public static int removeDuplicates(int[] nums) {
        // 区间[0,slow]中的元素都是排序数组中只出现一次的元素
        int slow = 0;
        // 快指针fast的初始值为1，因为数组是排好序的
        // 因此数组中的第一个元素是一定存在于返回数组中的。
        for(int fast = 1; fast < nums.length; fast++) {
            // 当前考察的元素nums[fast]和nums[slow]不相等时
            // 说明nums[fast]是需要放入区间[0,slow]中的
            if (nums[fast] != nums[slow]) {
                // slow++是因为区间[0,slow]是左闭右闭的
                // 因此，在slow加1之后，在将nums[fast]的值赋予nums[slow]
                slow++;
                nums[slow] = nums[fast];
            }
        }
        // j指向的是新数组中末尾的元素，即新数组最后的索引
        // 而索引从0开始，题目要求返回新数组的长度，因此返回slow+1
        return slow + 1;
    }

}
