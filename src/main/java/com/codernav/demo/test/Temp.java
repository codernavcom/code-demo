package com.codernav.demo.test;

public class Temp {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int num = f1(nums, 7);
        System.out.println(num);

    }

    private static int f1(int[] nums, int s) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= s) {
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // 暴力算法
    private static int f(int[] nums, int s) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= s) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }

        }
        return minLength;
    }


}
