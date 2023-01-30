package com.codernav.demo.hwod;

/**
 * 统计N以内的素数
 * 暴力算法
 * 素数：只能被1和自身整除的数，0、1除外
 * 原文地址：https://www.codernav.com/
 */
public class Odtest06 {
    public static void main(String[] args) {
        int count = f(100);
        // 输出：25
        System.out.println(count);
    }

    private static int f(int n) {
        int count = 0;
        // 从2开始n-1结束，因为1和n除外，要排除掉
        for (int i = 2; i < n; i++) {
//            count += check(i) ? 1 : 0;
          count += check1(i) ? 1 : 0;
        }
        return count;
    }

    /**
     * 如果是素数，返回true，否则返回false
     */
    private static boolean check(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化暴力算法
     * 实际上，for循环遍历时，j只需要<=根号i即可，降低时间复杂度
     * 举例：12,可以拆解成2x6,3x4,4x3,6x2,只需要判断前两个成立即可，后面两个没必要重复判断
     * j * j <= i 等价于 j <= 根号i
     */
    private static boolean check1(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
