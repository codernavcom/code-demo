package com.codernav.demo.leetcode.array.minsubarraylen;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Q_76 {
    public static void main(String[] args) {
        String subResult = f("ADOBECODEBANC", "ABC");
        System.out.println(subResult);
    }

    private static String f(String s, String t) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;


        return null;
    }

    private static boolean contains(String text, String subText) {
        for (char c : subText.toCharArray()) {
            if (!text.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
}
