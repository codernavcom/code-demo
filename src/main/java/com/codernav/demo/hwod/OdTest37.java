package com.codernav.demo.hwod;


import com.codernav.demo.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序
 * 给你二叉树的根节点root ，返回它节点值的层序遍历。
 * 原文地址：https://www.codernav.com/2855.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest37 {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        f(node1);
    }

    private static List<List<Integer>> f(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        // 定义一个先进先出的队列，放入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 用于记录每层的节点数，每从队列中取出一个元素，size--
            int size = queue.size();
            // 存放每层的元素
            List<Integer> list = new ArrayList<>();
            // 题目要求每层单独放一个数组中，用这种方式记录上层循环放入队列的个数
            while (size > 0) {
                // 取出元素
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;

            }
            lists.add(list);
        }
        return lists;
    }
}

