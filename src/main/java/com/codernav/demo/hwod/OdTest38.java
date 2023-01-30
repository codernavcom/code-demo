package com.codernav.demo.hwod;


import com.codernav.demo.common.TreeNode;

import java.util.Stack;

/**
 * 前序-迭代-栈（stack）
 * 给你二叉树的根节点root ，返回它节点值的前序遍历。
 * 原文地址：https://www.codernav.com/2855.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest38 {

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
        // 使用stack记录递归路径，左子节点后添加,保证先出栈
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            // 从栈顶取元素
            TreeNode node = stack.pop();
            if (node != null) {
                System.out.println(node.val);
                // 先入右子节点
                stack.push(node.right);
                // 再入左子节点
                stack.push(node.left);
            }
        }


    }
}

