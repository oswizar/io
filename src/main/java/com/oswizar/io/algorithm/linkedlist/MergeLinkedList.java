package com.oswizar.io.algorithm.linkedlist;

public class MergeLinkedList {


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 62.70%
     * 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 51.37%
     * 的用户
     */

    /**
     * 21. 合并两个有序链表
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//        ListNode temp = dummy;
//        // 把l1,l2中较小的结点链接到临时链表后,同时移动较小结点的链表和临时链表
//        while (l1 != null && l2 != null) {
//            if ((l1.val > l2.val)) {
//                temp.next = l2;
//                l2 = l2.next;
//            } else {
//                temp.next = l1;
//                l1 = l1.next;
//            }
//            temp = temp.next;
//        }
//        // 把l1,l2中还没合并的直接链接到临时链表后即可
//        temp.next = l1 == null ? l2 : l1;
//        return dummy.next;
//    }


    /**
     * 21. 合并两个有序链表
     * 递归依次找出l1,l2中较小结点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
    }
}
