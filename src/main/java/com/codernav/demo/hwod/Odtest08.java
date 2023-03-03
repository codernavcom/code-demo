package com.codernav.demo.hwod;

/**
 * 删除排序数组中的重复项
 * 描述：一个有序数组nums，原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 * 重点考察：双指针算法
 * 原文地址：https://www.codernav.com/2788.html
 */
public class Odtest08 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 3, 4};
        System.out.println(f(arr));
    }

    private static int f(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[slow] != arr[fast]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return slow + 1;
    }
}
