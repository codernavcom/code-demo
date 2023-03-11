package com.codernav.demo.hwod;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * https://leetcode.cn/problems/largest-number/
 * 原文地址：
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest19 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(f(nums));
    }

    private static String f(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + "");
        }

        // 对集合进行排序，排序规则：正反拼接，哪个大哪个排前面
        list.sort((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1); // 如果str1.compareTo(str2)，就是递增了
        });

        // 把每个元素连起来
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s);
        }

        // 特殊值
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();

    }
}
