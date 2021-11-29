package com.oswizar.interview.escape;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void main(String[] args) {
        Node node = null;
        System.out.println(node.next);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // 创建一个哈希表,key是原节点,value是新节点
        Map<Node, Node> map = new HashMap<>();

        Node copyHead = head;
        // 先遍历原链表,将原节点作为key,新节点作为value放入哈希表中
        while (copyHead != null) {
            map.put(copyHead, new Node(copyHead.val));
            copyHead = copyHead.next;
        }

        // 再遍历原链表,将新链表的next和random指针给设置上
        copyHead = head;
        while (copyHead != null) {
            // copyHead是原节点，map.get(copyHead)是对应的新节点
            Node newNode = map.get(copyHead);
            // 设置新节点的next
            newNode.next = map.get(copyHead.next);
            // 设置新节点的random
            newNode.random = map.get(copyHead.random);
            copyHead = copyHead.next;
        }

        // 返回新链表的头结点
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
