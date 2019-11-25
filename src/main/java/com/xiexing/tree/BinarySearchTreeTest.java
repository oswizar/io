package com.xiexing.tree;

/**
 * @date: 2019/6/4 13:35
 * @author: oswizar
 * @description: 二叉搜索树测试
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree b  = new BinarySearchTree();
        b.insert(3);b.insert(8);b.insert(1);b.insert(4);b.insert(6);
        b.insert(2);b.insert(10);b.insert(9);b.insert(20);b.insert(25);

        // 打印二叉树
        b.toString(BinarySearchTree.root);
        System.out.println();
    }
}
