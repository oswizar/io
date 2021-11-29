package com.oswizar.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

//    private void preorder(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        res.add(root.val);
//        preorder(root.left, res);
//        preorder(root.right, res);
//    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }
}
