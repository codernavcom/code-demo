package com.codernav.demo.hwod;

/**
 * 使用迭代方式解决“链表反转”问题
 * 题目：给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * 原文地址：https://www.codernav.com/2775.html
 */
public class OdTest05 {
    static class ListNode {
        int val;
        OdTest04.ListNode next;

        public ListNode(int val, OdTest04.ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        // node1 -> node2 -> node3 -> node4 -> node5
        OdTest04.ListNode node5 = new OdTest04.ListNode(5, null);
        OdTest04.ListNode node4 = new OdTest04.ListNode(4, node5);
        OdTest04.ListNode node3 = new OdTest04.ListNode(3, node4);
        OdTest04.ListNode node2 = new OdTest04.ListNode(2, node3);
        OdTest04.ListNode node1 = new OdTest04.ListNode(1, node2);
        OdTest04.ListNode prev = f(node1);
        System.out.println(prev);
    }

    /**
     * 递归方式
     * @param head
     * @return
     */
    public static OdTest04.ListNode f(OdTest04.ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归的目的是找到最后一个元素，从后往前执行下面的算法，如果从前往后执行，会导致执行一次算法后，链接断开
        OdTest04.ListNode newHead = f(head.next);
        // 将后一个节点的next节点指向head
        head.next.next = head;
        // 将后一个节点指向null
        head.next = null;
        return newHead;
    }
}
