package com.xiexing.algorithm.linkedlist;

import org.junit.Test;

public class RemoveNthFromEnd {

    /**
     * 1->2->3->4->5, 和 n = 2.key = l - n + 1
     * 1->2->3->5.
     * <p>
     * 设置一个指向哑结点的指针，并移动它遍历链表，直至它到达第(L - n)个结点那里。
     * 我们把第(L - n)个结点的 next 指针重新链接至第(L - n + 2)个结点
     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int len = 0;
//        // 定义一个临时结点
//        ListNode temp = head;
//        // 计算链表的长度
//        while (temp != null) {
//            len++;
//            temp = temp.next;
//        }
//        // 定义一个哑结点
//        ListNode dummy = new ListNode(0);
//        // 哑结点指向头结点
//        dummy.next = head;
//        temp = dummy;
//        // 遍历到第len-n个结点
//        len = len - n;
//        while (len > 0) {
//            len--;
//            temp = temp.next;
//        }
//        // 删除指定结点(即第len-n+1)
//        temp.next = temp.next.next;
//        // 返回头结点
//        return dummy.next;
//    }

    /**
     * 使用两个指针,第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。
     * 当第一个指针到达最后一个结点,此时第二个指针将指向从最后一个结点数起的第 n+1 个结点。
     * 重新链接第二个指针所引用的结点的 next 指针,指向该结点的下下个结点即可。
     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        // 定义一个哑结点
//        ListNode dummy = new ListNode(0);
//        // 哑结点指向head
//        dummy.next = head;
//        // 初始化两个辅助指针
//        ListNode first = dummy;
//        ListNode second = dummy;
//        int len = n + 1;
//        // 先让first指针走到n+1的位置
//        while (len > 0) {
//            first = first.next;
//            len--;
//        }
//        // second从链表开头，与first保持n的间隔，同时移动，直到first到链表尾部
//        while (first != null) {
//            first = first.next;
//            second = second.next;
//        }
//        // 把第(L - n)个结点的 next 指针重新链接至第(L - n + 2)个结点
//        second.next = second.next.next;
//        return dummy.next;
//    }


    /**
     * 19. 删除链表的倒数第N个节点(双指针法)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义一个哑结点
        ListNode dummy = new ListNode(0);
        // 哑结点指向head
        dummy.next = head;
        // 定义双指针
        ListNode slow, fast;
        // 初始化双指针
        slow = fast = dummy;
        // 先让 fast 走 n 步
        while (n-- >= 0) {
            fast = fast.next;
        }
        // fast 和 slow 以相同的速度同时前进，直到 fast 走到链表尾部
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow.next 就是倒数第 n 个节点，删除它
        slow.next = slow.next.next;
        return dummy.next;
    }


    @Test
    public void show() {
        int i = 3;
        while (--i > 0) {
            System.out.println(i);
        }
    }


}
