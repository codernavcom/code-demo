package com.codernav.demo.leetcode.array.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Q_704 {
    // nums = [-1,0,3,5,9,12], target = 9
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        // 自己实现二分查找
        System.out.println(f(nums, target));
        // Arrays.binarySearch
        System.out.println(Arrays.binarySearch(nums, target));
        // Collections.binarySearch（要先转为List集合）
        List<Integer> nums1 = Arrays.asList(-1, 0, 3, 5, 9, 12);
        System.out.println(Collections.binarySearch(nums1, target));
    }

    private static int f(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] == target) {
                return mid;
            }
        }

        return -1;
    }
}
