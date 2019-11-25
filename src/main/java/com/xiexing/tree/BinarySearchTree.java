package com.xiexing.tree;

/**
 * @date: 2019/6/4 10:49
 * @author: oswizar
 * @description: 二叉搜索树
 */
public class BinarySearchTree {

    /**
     * 定义二叉树的根节点
     */
    public static TreeNode root = null;

    /**
     * 定义树节点的数据结构
     */
    public static class TreeNode {
        /**
         * 节点值
         */
        int value;

        /**
         * 左节点
         */
        TreeNode left;

        /**
         * 右节点
         */
        TreeNode rigth;

        public TreeNode(int value) {
            this.value = value;
        }
    }


    /**
     * 二叉树插入
     */
    public TreeNode insert(int key) {
        // 新增节点
        TreeNode newNode = new TreeNode(key);
        // 当前节点
        TreeNode current = root;
        // 父节点
        TreeNode parent = null;

        // 如果根节点为空，新增节点即为根节点
        if (root == null) {
            root = newNode;
            return newNode;
        }

        while (true) {
            parent = current;
            if (key < current.value) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return newNode;
                }
            } else {
                current = current.rigth;
                if (current == null) {
                    parent.rigth = newNode;
                    return newNode;
                }
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void toString(TreeNode root) {
        if (root != null) {
            toString(root.left);
            System.out.println("value = " + root.value  + "|left = " + root.left+"|right = " + root.rigth);
            toString(root.rigth);
        }
    }
}



