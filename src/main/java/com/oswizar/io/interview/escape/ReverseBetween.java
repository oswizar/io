package com.oswizar.io.interview.escape;

import com.oswizar.io.algorithm.linkedlist.ListNode;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right) {
            return head;
        }
        // 定义辅助节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        // 让head移动到m节点的前一个节点
        for (int j = 1; j < left; j++) {
            head = head.next;
        }

        // 定义m节点的前一个节点
        ListNode prevM = head;
        // 定义m节点
        ListNode mNode = head.next;
        // 定义n节点(先初始化为m节点)
        ListNode nNode = mNode;
        // 定义n节点的后一个节点
        ListNode postN = nNode.next;

        // 将m~n之间的节点进行反转(mNode类比prev,postN类比curr)
        for (int j = left; j < right; j++) {
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }

        // 指针调整
        prevM.next = nNode;
        mNode.next = postN;

        return dummy.next;
    }


}
