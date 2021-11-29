package com.oswizar.interview.escape;

class MinStack {

    private Node head;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // 返回 -3.
        System.out.println(minStack.getMin());
        minStack.pop();
        // 返回 0.
        System.out.println(minStack.top());
        // 返回 -2.
        System.out.println(minStack.getMin());
    }

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
