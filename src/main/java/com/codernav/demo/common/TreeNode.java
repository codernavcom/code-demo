package com.codernav.demo.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    // 深度（广度优先维护深度）
    public int deep;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
