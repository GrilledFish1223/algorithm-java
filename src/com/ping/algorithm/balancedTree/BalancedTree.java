package com.ping.algorithm.balancedTree;

import com.ping.entity.TreeNode;

public class BalancedTree {

    public boolean isBalanced(TreeNode head) {
        return process(head).isBalanced;
    }

    static class ReturnType {
        public boolean isBalanced;
        public int height;

        public  ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }

        ReturnType l = process(head.left);
        ReturnType r = process(head.right);

        int h = Math.max(l.height, r.height) + 1;
        boolean isB = l.isBalanced && r.isBalanced && Math.abs(l.height - r.height) < 2;
        return new ReturnType(isB, h);
    }
}

