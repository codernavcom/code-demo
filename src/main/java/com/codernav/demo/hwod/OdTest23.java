package com.codernav.demo.hwod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和（单个for循环）
 * 给定一个升序排列的整数数组numbers，从数组中找出两个数满足相加之和等于目标数target。
 * 假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
 * 返回两数的下标值，以数组形式返回。
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest23 {
    public static void main(String[] args) {
        int[] result = f(new int[]{1, 2, 3, 4, 5, 6}, 10);
        System.out.println(Arrays.toString(result));
    }

    private static int[] f(int[] nums, int target) {
        // 定义map，存放已经遍历的元素，key:元素值，value：元素索引
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 当前遍历元素是nums[i]，我们要找的元素是target - nums[i]
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            // 如果集合中没有target - nums[i]，将元素加入集合，继续遍历，直到满足条件
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
