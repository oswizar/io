package com.oswizar.io.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点先入队
        queue.add(root);

        while (!queue.isEmpty()) {
            // 当层元素的个数
            int curLevelSize = queue.size();
            List<Integer> curLevelList = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                // 当前节点出队
                TreeNode node = queue.remove();
                curLevelList.add(node.val);
                // 左子树入队
                if (node.left != null) {
                    queue.add(node.left);
                }

                // 右子树入队
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 把每层的遍历完成的中间结果放入结果集(正序)
            res.add(curLevelList);
            // 把每层的遍历完成的中间结果放入结果集(逆序)
//            res.add(0,curLevelList);
        }
        return res;
    }
}
