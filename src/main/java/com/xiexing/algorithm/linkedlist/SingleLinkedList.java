package com.xiexing.algorithm.linkedlist;

public class SingleLinkedList {

    // 定义头节点
    private Node head;
    // 获取链表的长度（结点的个数）
    private int length = 0;

    public SingleLinkedList() {
        this.head = null;
    }

    // 在链表的头部添加节点
    public void addToHead(int val) {
        Node node = new Node(val);
        if (null != head) {
            node.setNext(head);
        }
        head = node;
        length++;
    }

    // 在链表的尾部添加节点
    public void addToTail(int val) {
        Node node = new Node(val);
        if (null == head) {
            head = node;
        } else {
            Node tmp = head;
            while (null != tmp.getNext()) {
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
        }
        length++;
    }




    /**
     * 历史遗留问题：从尾部递归添加节点
     * @param node
     */
    public void addNode(Node node){
        if(null==head) {
            head = node;
        } else{
            addNode(node.getNext());
        }
        length++;

    }




    // 在链表的头部删除节点
    public Boolean removeHead() {
        if (null == head) {
            return false;

        } else {
            Node curNode = head;
            head = (curNode.getNext());
            length--;
            return true;
        }
    }

    // 计算链表的长度
    public int length() {
        int length = 0;
        Node node = head;
        while (null != node) {
            length++;
            node = node.getNext();
        }
        return length;
    }

    // 遍历链表
    public void print() {
        Node tmp = head;
        while (null != tmp) {
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }


    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(new Node(3));
        singleLinkedList.addNode(new Node(4));
        singleLinkedList.addNode(new Node(6));
        singleLinkedList.addNode(new Node(1));


//        singleLinkedList.addToTail(4);
//        singleLinkedList.addToTail(3);
//        singleLinkedList.addToTail(5);
//        singleLinkedList.addToTail(6);
//        singleLinkedList.addToTail(8);
//        singleLinkedList.addToTail(3);
//        singleLinkedList.addToTail(9);
//        singleLinkedList.addToTail(1);

//        singleLinkedList.addToHead(4);
//        singleLinkedList.addToHead(3);
//        singleLinkedList.addToHead(5);
//        singleLinkedList.addToHead(6);
//        singleLinkedList.addToHead(8);
//        singleLinkedList.addToHead(3);
//        singleLinkedList.addToHead(9);
//        singleLinkedList.addToHead(1);

        singleLinkedList.print();
        System.out.println("--------------------------------");
        singleLinkedList.removeHead();
        singleLinkedList.print();

        singleLinkedList.addToHead(10);
        singleLinkedList.addToTail(20);
        System.out.println("--------------------------------");
        singleLinkedList.print();


    }

}
