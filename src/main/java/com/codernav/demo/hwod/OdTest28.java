package com.codernav.demo.hwod;


import com.codernav.demo.common.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 环形链表（2种解法）
 * 给你一个链表的头节点head, 判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。否则，返回 false
 * 原文地址：https://www.codernav.com/2816.html
 * 更多算法详解：https://www.codernav.com
 */
public class OdTest28 {
    public static void main(String[] args) {
        // 定义链表
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        // 定义环形链表，将node5指向node3
        node5.next = node3;
        // 哈希表
        boolean exist1 = f1(node1);
        System.out.println(exist1);
        // 双指针
        boolean exist2 = f2(node1);
        System.out.println(exist2);
        // ArrayList
        boolean exist = f(node1);
        System.out.println(exist);
    }

    public static boolean f(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            // 集合中已经存在node了，说明之前已经出现过了，该节点被指向两次
            if (list.contains(head)) {
                return true;
            }
            // 如果集合中没有，将当前节点存入集合
            list.add(head);
            // 当前节点指向下一个节点继续遍历
            head = head.next;
        }
        return false;
    }

    public static boolean f1(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            // boolean add = seen.add(head);该方法返回一个布尔值，如果Set中已存在元素，则再次添加会返回false
            if (!seen.add(head)) {
                return true;
            }
            // 当前节点指向下一个节点继续遍历
            head = head.next;
        }
        return false;
    }

    public static boolean f2(ListNode head) {
        //初始化快慢指针指向头节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            //快指针每次前进两步
            fast = fast.next.next;
            //慢指针每次前进一步
            slow = slow.next;
            // 如果含有环，快指针最终会超慢指针一圈，和慢指针相遇
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
