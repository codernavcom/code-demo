package com.codernav.demo.hwod;

/**
 * 使用迭代方式解决“链表反转”问题
 * 题目：给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * 原文地址：https://www.codernav.com/2775.html
 */
public class OdTest04 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        // node1 -> node2 -> node3 -> node4 -> node5
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode prev = f(node1);
        System.out.println(prev);
    }

    /**
     * 递归方式
     * @param head
     * @return
     */
    public static ListNode f1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归的方式找到最后一个元素
        ListNode newHead = f1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代方式
     * @param head
     * @return
     */
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


