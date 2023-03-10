package com.codernav.demo.hwod;

/**
 * @title 123. 买卖股票的最佳时机 III
 * @Description 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * @Author 开发者导航
 * @website https://www.codernav.com
 * @date 2023/3/9
 */
public class OdTest43 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        // 动态规划
        System.out.println(maxProfit(nums));
        // 空间优化
        System.out.println(maxProfit1(nums));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;

        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
        }

        return dp[len - 1][4];
    }

    // 空间优化
    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }

        return dp[4];
    }
}
