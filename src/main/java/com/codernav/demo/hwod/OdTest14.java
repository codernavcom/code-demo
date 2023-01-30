package com.codernav.demo.hwod;

import java.util.HashMap;
import java.util.Map;

/**
 * 青蛙跳台阶（带缓存方案）
 * 问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 原文地址：https://www.codernav.com/2788.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest14 {
    public static void main(String[] args) {
        // 1.定义缓存结构
        Map<Integer, Integer> cacheMap = new HashMap<>();
        int way = f(10, cacheMap);
        // 输出：89
        System.out.println(way);
    }

    private static int f(int n, Map<Integer, Integer> cacheMap) {
        if (n <= 2) {
            cacheMap.put(n, n);
            return n;
        }
        // 2.先从缓存中查
        if (cacheMap.containsKey(n)) {
            return cacheMap.get(n);
        }
        // 3.缓存中没有，使用递归计算
        int way = f(n - 1, cacheMap) + f(n - 2, cacheMap);
        // 4.加入缓存
        cacheMap.put(n, way);
        return way;
    }
}
