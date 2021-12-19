package com.oswizar.io.algorithm.linkedlist;

public class HasCycle {

    /**
     * 141. 环形链表(快慢指针法)
     */
    public boolean hasCycle(ListNode head) {
        // 定义两个快慢指针
        ListNode slow, fast;
        // 初始化快慢指针都指向头指针
        slow = fast = head;
        // 快指针先走完发现没环，直接退出循环返回
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果快指针 套圈 追到慢指针，证明有环
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    /**
     * 142. 环形链表 II(快慢指针法)
     */
    public ListNode detectCycle(ListNode head) {
        // 定义两个快慢指针
        ListNode slow, fast;
        // 初始化快慢指针都指向头指针
        slow = fast = head;
        // 快指针先走完发现没环，直接退出循环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果快指针 套圈 追到慢指针，证明有环
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // 运行到此，快慢指针到达相遇点，重置慢指针到链表的头部
        slow = head;
        while (slow != fast) {
            // 快慢指针以相同的速度继续前行，直到相遇
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
