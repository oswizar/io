package com.oswizar.interview.escape;

import com.oswizar.algorithm.linkedlist.ListNode;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
        // intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }
        return pa;
    }


//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        // intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//        List<ListNode> visited = new ArrayList<>();
//        ListNode temp = headA;
//        while (temp != null) {
//            visited.add(temp);
//            temp = temp.next;
//        }
//        temp = headB;
//        while (temp != null) {
//            if (visited.contains(temp)) {
//                return temp;
//            }
//            temp = temp.next;
//        }
//        return null;
//    }
}
