package com.oswizar.io.algorithm.linkedlist;

public class Node {

    /**
     * data 表示链表中每个节点的数据
     * next 表示链表中每个节点指向的下一个节点的引用
     */
    private int data;
    private Node next;

    public Node(int val) {
        data = val;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
