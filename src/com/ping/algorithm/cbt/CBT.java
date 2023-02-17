package com.ping.algorithm.cbt;

import com.ping.entity.TreeNode;

import java.util.LinkedList;

/**
 * CBT 判断二叉树是否完全二叉树
 */
public class CBT {
    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        TreeNode left = null;
        TreeNode right = null;
        queue.add(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;

            // 1. leaf 出现过一次孩子不双全， 说明只能在叶子节点， 叶子节点没有双节点。
            // 2. 左节点为空， 则右节点不能有双节点。
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
