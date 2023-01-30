package com.codernav.demo.leetcode.slidingwindow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 */
public class Q_209 {
    public static void main(String[] args) {
        System.out.println(handler(new int[]{2, 3, 1, 2, 4, 3}, 7));
    }

    static int handler(int[] nums, int target) {
        int left = 0;
        int right = 0;
        int curSum = 0;
        int minLength = 0;
        while (right < nums.length) {
            curSum = curSum + nums[right];
            // 当窗口满足要求的时候，收缩左边界，并更新最优解
            while (curSum >= target) {
                if (right - left + 1 < minLength || minLength == 0) {
                    minLength = right - left + 1;
                }
                curSum = curSum - nums[left];
                left++;
            }
            // 当窗口不满足要求的时候，向右拓宽边界
            right++;
        }
        return minLength;
    }

}
