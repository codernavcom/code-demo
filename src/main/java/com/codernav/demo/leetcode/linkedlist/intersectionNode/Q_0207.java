package com.codernav.demo.leetcode.linkedlist.intersectionNode;

import com.codernav.demo.common.ListNode;

/**
 * @title 面试题 02.07. 链表相交
 * @Description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * @Author 开发者导航
 * @website https://www.codernav.com
 * @date 2023/3/5
 */
public class Q_0207 {
    public static void main(String[] args) {
        // 链表A
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(8, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(4, node2);
        // 链表B，与链表A交叉在node3
        ListNode node33 = new ListNode(1, node3);
        ListNode node22 = new ListNode(6, node33);
        ListNode node11 = new ListNode(5, node22);

        ListNode node = f(node1, node11);
        System.out.println(node);

    }

    private static ListNode f(ListNode headA, ListNode headB) {
        // node1的长度
        ListNode dummyNodeA = new ListNode(-1);
        dummyNodeA.next = headA;
        ListNode currA = dummyNodeA;
        int sizeA = 0;
        while (currA.next != null) {
            sizeA++;
            currA = currA.next;
        }

        // node2的长度
        ListNode dummyNodeB = new ListNode(-1);
        dummyNodeB.next = headB;
        ListNode currB = dummyNodeB;
        int sizeB = 0;
        while (currB.next != null) {
            sizeB++;
            currB = currB.next;
        }

        // 求长度差
        int diff = sizeA > sizeB ? sizeA - sizeB : sizeB - sizeA;

        // 让两个链表的指针在同一起点上（末尾位置对齐，就是让长的链表指针先跑diff个长度）
        for (int i = 0; i < diff; i++) {
            if (sizeA > sizeB) {
                dummyNodeA = dummyNodeA.next;
            } else {
                dummyNodeB = dummyNodeB.next;
            }
        }

        // 同时跑两个指针，判断是否相同，相同则直接返回，不同继续遍历
        while (dummyNodeA.next != null) {
            if (dummyNodeA.next == dummyNodeB.next) {
                return dummyNodeA.next;
            }
            dummyNodeA = dummyNodeA.next;
            dummyNodeB = dummyNodeB.next;
        }

        return null;
    }
}
