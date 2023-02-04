package com.codernav.demo.leetcode.array.removeelement;

/**
 * 844. 比较含退格的字符串（普通解法, 使用String模拟栈的思路）
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 原文地址：https://www.codernav.com/2903.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_844_1 {
    public static void main(String[] args) {
        // 普通方式，模拟栈
        f("ab#c#d", "ad#c");
    }

    private static boolean f(String s, String t) {
        // 模拟栈
        StringBuilder ssb = new StringBuilder();
        StringBuilder tsb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // if else同时成立时，第一个条件满足后即跳出条件表达式
            if (c != '#') {
                ssb.append(c); // 模拟入栈
            } else if (ssb.length() > 0) { // 栈非空才能弹栈
                ssb.deleteCharAt(ssb.length() - 1); // 模拟弹栈
            }
        }
        for (char c : t.toCharArray()) {
            if (c != '#') {
                tsb.append(c); // 模拟入栈
            } else if (tsb.length() > 0) { // 栈非空才能弹栈
                tsb.deleteCharAt(tsb.length() - 1); // 模拟弹栈
            }
        }

        return ssb.toString().equals(tsb.toString());

    }
}
