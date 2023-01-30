package com.codernav.demo.hwod;

/**
 * 求所有不同的路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）
 * 机器人每次只能向下或向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）
 * 求总共有多少条不同的路径？
 * 原文地址：https://www.codernav.com/2788.html
 */
public class OdTest12 {
    public static void main(String[] args) {
        int way = f(7, 4);
        System.out.println(way);
    }

    private static int f(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // 初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }
}
