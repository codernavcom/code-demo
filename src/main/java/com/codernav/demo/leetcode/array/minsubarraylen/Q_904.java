package com.codernav.demo.leetcode.array.minsubarraylen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 904. 水果成篮
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * https://leetcode.cn/problems/fruit-into-baskets/
 *
 */
public class Q_904 {
    public static void main(String[] args) {
        // 这道题目可以理解为求只包含两种元素的最长连续子序列
        int[] nums = new int[]{1, 2, 3, 2, 2};
        // 暴力算法
        System.out.println(f(nums));
        // 滑动窗口
        System.out.println(f1(nums));
    }

    /**
     * 滑动窗口模板：求最大值
     * 初始化 left，right，result，bestResult
     * while("右指针没有到结尾"){
     *     窗口扩大，加入right对应元素，更新当前result
     *     while("result不满足要求"){
     *         窗口缩小，移除left对应元素，left右移
     *     }
     *     更新最优结果bestResult（注意在while外更新！）
     *     right++;
     * }
     * 返回bestResult
     */
    private static int f1(int[] fruits) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            // 不满足条件
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            // 注意：最大滑窗是在右指针右移的过程中更新结果
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }


    // 暴力算法（leetcode会超时）
    private static int f(int[] fruits) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < fruits.length; j++) {
                set.add(fruits[j]);
                if (set.size() > 2) {
                    break;
                } else {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
