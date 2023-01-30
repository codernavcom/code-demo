package com.codernav.demo.hwod;


import com.codernav.demo.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度（广度优先）
 * 给定一个二叉树，找出其最小深度，求最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 原文地址：https://www.codernav.com/2845.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest32 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        // 广度优先
        System.out.println(f(node1));
    }

    public static int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 使用链表实现一个先进先出的队列
        Queue<TreeNode> queue = new LinkedList<>();
        // TreeNode无法记录深度，需要新增字段deep
        root.deep = 1;
        // 向队列添加元素，offer()与add()区别是当队列满了时不会抛异常，而是返回false
        queue.offer(root);
        // 队列为空跳出循环
        while (!queue.isEmpty()) {
            // 取出元素
            TreeNode node = queue.poll();
            // 左右节点都为空，则为叶子结点，循环结束
            if (node.left == null && node.right == null) {
                return node.deep;
            }
            // 不为空，则加入队列
            if (node.left != null) {
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }

        }

        return 0;

    }
}