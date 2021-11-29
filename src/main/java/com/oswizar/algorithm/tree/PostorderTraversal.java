package com.oswizar.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

//    private void postorder(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        postorder(root.left, res);
//        postorder(root.right, res);
//        res.add(root.val);
//    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();

            if (root.right == null || root.right == prev) {
                res.add(root.val);
                stack.pop();
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }
    }
}
