package com.codernav.demo.leetcode.listnode;

import com.codernav.demo.common.ListNode;

/**
 * @title 203. 移除链表元素
 * @Description 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @Author 开发者导航
 * @website https://www.codernav.com
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * @date 2023/2/26
 */
public class Q_203 {
    public static void main(String[] args) {
        // 1,2,6,3,4,5,6
        ListNode node7 = new ListNode(6, null);
        ListNode node6 = new ListNode(5, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(6, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode newHead = f(node1, 6);
        ListNode newHead1 = f1(node1, 6);

    }

    private static ListNode f1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 递归
        head.next = f1(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }

    }

    private static ListNode f(ListNode head, int val) {
        // 考虑头结点值相等，且删除后的头结点依然相同的问题
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
