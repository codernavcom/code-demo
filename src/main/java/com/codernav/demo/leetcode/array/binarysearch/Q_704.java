package com.codernav.demo.leetcode.array.binarysearch;

public class Q_704 {
    // nums = [-1,0,3,5,9,12], target = 9
    public static void main(String[] args) {
        int index = f(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(index);
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
