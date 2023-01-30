package com.codernav.demo.hwod;


import com.codernav.demo.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树遍历-后序-递归
 * 给你二叉树的根节点root ，返回它节点值的后序遍历。
 * 原文地址：https://www.codernav.com/2855.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest36 {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        List<Integer> list = f(node1);
        // 4 6 7 5 2 3 1
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static List<Integer> f(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return ff(root, list);
    }

    private static List<Integer> ff(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        ff(root.left, list);
        ff(root.right, list);
        list.add(root.val); // 第三次成为栈顶元素时加入集合（后序）
        return list;
    }
}

