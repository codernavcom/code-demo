package com.codernav.demo.leetcode.array.removeelement;

/**
 * 844. 比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 原文地址：https://www.codernav.com/2903.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_844_2 {
    public static void main(String[] args) {
        System.out.println(f("ab#c", "ad#c"));
    }

    private static boolean f(String s, String t) {
        int S_Len = s.length(), T_Len = t.length();
        char[] S_arr = s.toCharArray(), T_arr = t.toCharArray();
        int skipS = 0, skipT = 0;
        for (int i = S_Len - 1, j = T_Len - 1; i >= 0 || j >= 0; i--, j--) {
            while (i >= 0) {
                if (S_arr[i] == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    // 遇到字符, 但由于需要回退, 所以还需要前移1位
                    skipS--;
                    i--;
                } else {
                    // 遇到字符, 且不能回退了, 所以需要比对这个字符是否与T对应位置上的字符相等
                    break;
                }
            }
            while (j >= 0) {
                if (T_arr[j] == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S_arr[i] != T_arr[j]) return false;
            } else if (i >= 0 || j >= 0) {
                // 有其中一方已经遍历完整个字符串, 但另外一方没有遍历完整个字符串, 直接返回false
                return false;
            }
        }
        return true;
    }
}
