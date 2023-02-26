package com.ping.algorithm.lowestAncestor;

import com.ping.entity.TreeNode;

/**
 * 1.  o1 是o2 的最低公共祖先，返回o1
 * A
 * o1       C
 * D     o2  F    G
 * <p>
 * 2. o1与o2 不互为公共祖先， 向上找 。  返回 A
 * A
 * o1       C
 * D     E  F    o2
 */
public class LowestAncestor {
    public TreeNode lowestAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestAncestor(root.left, p, q);
        TreeNode right = lowestAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        // 左右两棵树，并不都返回值
        return left != null ? left : right;
    }
}
