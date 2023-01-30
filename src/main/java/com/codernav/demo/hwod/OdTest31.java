package com.codernav.demo.hwod;


import com.codernav.demo.common.TreeNode;

/**
 * 二叉树的最小深度（深度优先）
 * 给定一个二叉树，找出其最小深度，求最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 原文地址：https://www.codernav.com/2843.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest31 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        // 递归 深度优先
        System.out.println(f(node1));
    }

    public static int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 1.判断是否为子节点，子节点的深度为1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 最小深度 设置为一个最大值（重要）
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(f(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(f(root.right), min);
        }
        // 深度+1
        return min + 1;
    }
}