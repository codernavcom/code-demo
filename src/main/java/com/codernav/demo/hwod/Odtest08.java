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
        // i慢指针，j快指针
        int i = 0;
        // 第一次遍历：i=0,j=1 -> 0,1,2,2,3,3,4 i=1
        // 第二次遍历：i=1,j=2 -> 0,1,2,2,3,3,4 i=2
        // 第三次遍历：i=2,j=3 -> 0,1,2,2,3,3,4 i=2
        // 第四次遍历：i=2,j=4 -> 0,1,2,3,3,3,4 i=3
        // 第五次遍历：i=3,j=5 -> 0,1,2,3,3,3,4 i=3
        // 第六次遍历：i=3,j=6 -> 0,1,2,3,4,3,4 i=4
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
