package com.codernav.demo.leetcode.listnode.reverseList;

import com.codernav.demo.common.ListNode;

/**
 * @title 206. 反转链表
 * @Description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @Author 开发者导航
 * @website https://www.codernav.com
 * @date 2023/2/26
 */
public class Q_206 {
    public static void main(String[] args) {
        // 输入：head = [1,2,3,4,5] 输出：[5,4,3,2,1]
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        // 迭代
        System.out.println(f(node1));
        // 递归
        System.out.println(f1(node1));
    }

    public static ListNode f1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归的目的是找到最后一个元素，从后往前执行下面的算法，如果从前往后执行，会导致执行一次算法后，链接断开
        ListNode newHead = f(head.next);
        // 将后一个节点的next节点指向head
        head.next.next = head;
        // 将后一个节点指向null
        head.next = null;
        return newHead;
    }

    public static ListNode f(ListNode head) {
        // 后一个节点
        ListNode next;
        // 前一个节点
        ListNode prev = null;
        // 当前节点
        ListNode curr = head;
        // 循环结束条件：循环节点为空时
        while (curr != null) {
            // 保存指针
            next = curr.next;
            // 反转，将当前节点指向上一个节点
            curr.next = prev;
            // 把当前节点设置为前节点
            prev = curr;
            // 把当前节点指向后一个节点
            curr = next;
        }
        return prev;
    }
}
