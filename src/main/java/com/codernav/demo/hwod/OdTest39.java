package com.codernav.demo.hwod;


import com.codernav.demo.common.TreeNode;

import java.util.Stack;

/**
 * 中序-迭代-栈（stack）
 * 给你二叉.树的根节点root ，返回它节点值的中序遍历。
 * 原文地址：https://www.codernav.com/2855.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest39 {

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

    private static void f(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序：将左子节点入栈，出栈打印值，然后添加右子节点
        Stack<TreeNode> stack = new Stack<>();
        // 根节点不能先加入栈了
        // stack.add(root);
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                // 找到最左边的节点
                stack.push(root);
                root = root.left;
            } else {
                // 出栈
                root = stack.pop();
                System.out.println(root.val);
                // 右边节点入栈
                root = root.right;
            }
        }
    }
}

