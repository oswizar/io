package com.xiexing.algorithm.linkedlist;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class LinkedList {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 链表反转
     * 1->2->3->4->null
     * null<-1<-2<-3<-4<-null
     * 4->3->2->1->null
     *
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//
//        ListNode prev = null;
//        ListNode curr = head;
//
//        while (curr != null) {
//            ListNode temp = curr.next;
//            // 当前节点的next指针指向上一个节点
//            curr.next = prev;
//            // 把当前节点变成上一个节点
//            prev = curr;
//            // 选取下一个节点为当前节点
//            curr = temp;
//        }
//        return prev;
//    }


    /**
     * 链表反转(递归实现)
     * 1->2->3->4->null
     * null<-1<-2<-3<-4<-null
     * 4->3->2->1->null
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = reverseList(head.next);
        // 指针反转(当前节点的下一个节点的next指回当前节点)
        head.next.next = head;
        // 防止循环指向
        head.next = null;
        // 返回反转后的头节点
        return curr;
    }


    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义前置指针(用于固定结果链表的头节点)
        ListNode pre = new ListNode(0);
        // 定义当前指针(用于遍历链表)
        ListNode cur = pre;
        // 定义进位标识
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 如果当前节点提前结束,自动补0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            // 按位计算
            int sum = x + y + carry;

            // 计算进位
//            carry = sum / 10;
            carry = sum > 9 ? 1 : 0;
            // 计算新增节点的实际值
            sum = sum % 10;

            // 拼接结果链表
            cur.next = new ListNode(sum);
            // 重置当前节点
            cur = cur.next;

            // 继续遍历
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果进位上还有值,需要新增节点
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        // 前置节点的next正是结果链表的头节点
        return pre.next;
    }


//    class Solution {
//        public:
//        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
//            stack<int> s1, s2;
//            while (l1) {
//                s1.push(l1->val);
//                l1 = l1->next;
//            }
//            while (l2) {
//                s2.push(l2->val);
//                l2 = l2->next;
//            }
//            int sum = 0;
//            ListNode *res = new ListNode(0);
//            while (!s1.empty() || !s2.empty()) {
//                if (!s1.empty()) {sum += s1.top(); s1.pop();}
//                if (!s2.empty()) {sum += s2.top(); s2.pop();}
//                res->val = sum % 10;
//                ListNode *head = new ListNode(sum / 10);
//                head->next = res;
//                res = head;
//                sum /= 10;
//            }
//            return res->val == 0 ? res->next : res;
//        }
//    };


    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        Stack<ListNode> s1 = null;
//        Stack<ListNode> s2 = null;
//        while (l1 != null) {
//            s1.push(l1);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            s2.push(l2);
//            l2 = l2.next;
//        }
//        // 定义前置指针(用于固定结果链表的头节点)
//        ListNode pre = new ListNode(0);
//        // 定义当前指针(用于遍历链表)
//        ListNode cur = pre;
//        // 定义进位标识
//        int carry = 0;
//        while (!s1.empty() || !s2.empty()) {
//            int sum = 0;
//            if (!s1.empty()) {
//                sum += s1.peek().val;
//                s1.pop();
//            }
//            if (!s2.empty()) {
//                sum += s2.peek().val;
//                s2.pop();
//            }
//            carry = sum > 9 ? 1 : 0;
//            // 计算新增节点的实际值
//            sum = sum % 10;
//
//            // 拼接结果链表
//            cur.next = new ListNode(sum);
//            // 重置当前节点
//            cur = cur.next;
//
//        }
//        // 如果进位上还有值,需要新增节点
//        if (carry == 1) {
//            cur.next = new ListNode(carry);
//        }
//        // 前置节点的next正是结果链表的头节点
//        return pre.next;
//    }


}














































