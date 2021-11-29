package com.oswizar.interview.escape;

import com.oswizar.algorithm.linkedlist.ListNode;

public class DeleteNode {


    public void deleteNode(ListNode node) {
        // 用下一个节点的值覆盖当前节点的值
        node.val = node.next.val;
        // 用下下个节点覆盖下个节点
        node.next = node.next.next;
    }


    /**
     * 剑指 Offer 18. 删除链表的节点
     * head = [4,5,1,9], val = 5
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 若是删除第一个节点,直接返回下一个节点即可
        if (head.val == val) {
            return head.next;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        // 若找不到要删除的节点,向后平移双指针
        while (curr != null && curr.val != val) {
            prev = curr;
            curr = curr.next;
        }
        // 防止要删除的节点不存在链表中报NPE
        if (curr != null) {
            // 覆盖curr所指的节点
            prev.next = curr.next;
        }
        return head;
    }


}
