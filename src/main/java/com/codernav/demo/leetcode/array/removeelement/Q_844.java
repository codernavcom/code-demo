package com.codernav.demo.leetcode.array.removeelement;

/**
 * 844. 比较含退格的字符串（比较暴力的算法）
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 原文地址：https://www.codernav.com/2891.html
 * 更多算法详解：https://www.codernav.com
 */
public class Q_844 {
    public static void main(String[] args) {
        f("#ab#c#d", "ad#c");
    }

    private static boolean f(String s, String t) {

        // 如果字符串中包含#，对字符串进行处理
        while (s.contains("#")) {
            int pos = s.indexOf("#"); // #出现的位置，该方法只返回#出现的第一个位置
            StringBuilder sb = new StringBuilder(s);
            if (sb.indexOf("#") == 0) { // #在第一位单独处理，防止异常
                sb.deleteCharAt(0);
            } else {
                sb.delete(pos - 1, pos + 1); // #不在第一位，移除#和它的前一位置
            }
            s = sb.toString(); // 重新给字符串赋值
        }

        while (t.contains("#")) {
            int pos = t.indexOf("#");
            StringBuilder sb = new StringBuilder(t);
            if (sb.indexOf("#") == 0) {
                sb.deleteCharAt(0);
            } else {
                sb.delete(pos - 1, pos + 1);
            }
            t = sb.toString();
        }

        return s.equals(t);
    }
}
