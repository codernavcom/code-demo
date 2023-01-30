package com.codernav.demo.hwod;


import com.codernav.demo.common.TreeNode;

import java.util.Stack;

/**
 * 后序-迭代-双端.队列（Deque/stack）
 * 给你二叉.树的根节点root ，返回它节点值的后序遍历。
 * 原文地址：https://www.codernav.com/2855.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest40 {

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
        // 双端队列
//        Deque<TreeNode> stack = new LinkedList<>();
        // 栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            // 找到最左边的子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 出栈
            root = stack.pop(); // root的左子节点为null
            if (root.right == null || root.right == prev) { // 右子节点为null，或者右子节点已打印
                System.out.println(root.val);
                prev = root;
                root = null;
            } else { // 右子节点有值，重新入栈
                stack.push(root);
                root = root.right;
            }
        }
    }
}

