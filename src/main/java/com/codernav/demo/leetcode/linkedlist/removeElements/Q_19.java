package com.codernav.demo.leetcode.linkedlist.removeElements;

import com.codernav.demo.common.ListNode;

/**
 * @title 19. 删除链表的倒数第 N 个结点（循环迭代）
 * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Author 开发者导航
 * @website https://www.codernav.com
 * @date 2023/3/4
 */
public class Q_19 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = f(node1, 2);
        System.out.println(head);
    }

    public static ListNode f(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        // 求结点个数，注意不能直接操作head结点，使用临时结点
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // 倒数第n个，也是正数第size-n+1个
        int N = size - n + 1;

        // 虚拟结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        // 遍历到第n-1个时，删除结点
        int step = 0;
        while (prev.next != null) {
            if (step == N - 1) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
            step++;
        }

        return dummyNode.next;

    }
}
