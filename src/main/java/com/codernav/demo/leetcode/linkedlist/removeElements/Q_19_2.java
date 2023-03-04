package com.codernav.demo.leetcode.linkedlist.removeElements;

import com.codernav.demo.common.ListNode;

import java.util.Stack;

/**
 * @title 19. 删除链表的倒数第 N 个结点（栈）
 * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Author 开发者导航
 * @website https://www.codernav.com
 * @date 2023/3/4
 */
public class Q_19_2 {
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
        // 虚拟结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // 将结点放入栈（包括虚拟结点）
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = dummyNode;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        // 移除最后n个元素
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        // 找到要移除元素的前驱元素
        ListNode prev = stack.peek();
        // 删除结点
        prev.next = prev.next.next;

        return dummyNode.next;
    }
}
