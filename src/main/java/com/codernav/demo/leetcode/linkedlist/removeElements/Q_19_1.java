package com.codernav.demo.leetcode.linkedlist.removeElements;

import com.codernav.demo.common.ListNode;

/**
 * @title 19. 删除链表的倒数第 N 个结点（双指针）
 * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Author 开发者导航
 * @website https://www.codernav.com
 * @date 2023/3/4
 */
public class Q_19_1 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        // 双指针
        ListNode head = removeNthFromEnd(node1, 2);
        System.out.println(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        //只要快慢指针相差 n个结点即可
        for (int i = 0; i < n; i++) {
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }
}
