package com.codernav.demo.hwod;

/**
 * 斐波那契数列（3种解法）
 * 求取斐波那契数列第N位的值。
 * 斐波那契数列：前两位数字是固定的0和1，后面每一位的值等于他前两位数字之和：0,1,1,2,3,5,8……
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest26 {
    public static void main(String[] args) {
        // 解法一：暴力递归
        System.out.println(f1(10));
        // 解法二：去重递归(此处用数组存储，也可以用Map)
        int[] arr = new int[10 + 1];
        System.out.println(f2(arr, 10));
        // 解法三：双指针迭代
        System.out.println(f3(10));
    }

    public static int f1(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return f1(num - 1) + f1(num - 2);
    }

    public static int f2(int[] arr, int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (arr[num] != 0) {
            return arr[num];
        }
        arr[num] = f2(arr, num - 1) + f2(arr, num - 2);
        return arr[num];
    }

    public static int f3(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int low = 0, high = 1;
        for (int i = 2; i <= num; i++) {
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }


}
