package com.oswizar.io.algorithm.tree;

/**
 * 定义树节点的数据结构
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
         this.right = right;
     }
}
