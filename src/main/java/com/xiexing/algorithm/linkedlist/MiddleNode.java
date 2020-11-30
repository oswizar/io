package com.xiexing.algorithm.linkedlist;

public class MiddleNode {

    /**
     * 876. 链表的中间结点
     */
    public ListNode middleNode(ListNode head) {
        // 定义快慢双指针
        ListNode slow, fast;
        // 初始化快慢指针指向链表头部
        slow = fast = head;
        // 当快指针到达尾部时，慢指针刚好到达链表中间
        while (fast != null && fast.next != null) {
            // 快指针先出发
            fast = fast.next.next;
            // 慢指针后出发
            slow = slow.next;
        }
        return slow;
    }
}
