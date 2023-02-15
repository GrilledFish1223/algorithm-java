package com.ping.algorithm.bst;

import com.ping.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {
    public static void main(String[] args) {

    }

    public static int preValue  = Integer.MIN_VALUE;

    /**
     * 如何判断一颗二叉树是否是搜索二叉树 中序遍历 升序就是搜索二叉树
     * @param head
     * @return
     */
    public static boolean isBST(TreeNode head) {
        if (head == null) {
            return true;
        }

        boolean isLeftBst = isBST(head.left);
        if(!isLeftBst) {
            return false;
        }
        if (head.value<= preValue) {
            return false;
        } else {
            preValue = head.value;
        }

        return isBST(head.right);
    }

    public static boolean isBST2(TreeNode head) {
        if (head == null) {
            return true;
        }
        int preValue = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value <= preValue) {
                    return false;
                } else {
                    preValue = head.value;
                }
                head= head.right;
            }
        }
        return true;
    }

    public static boolean isBST3(TreeNode head) {
        if (head == null) {
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        process(head, list);
        long preValue = Long.MIN_VALUE;
        for (TreeNode cur: list) {
            if (preValue >= cur.value) {
                return false;
            }
            preValue = cur.value;
        }

        return true;
    }

    public static void process(TreeNode node , List<TreeNode> listNode) {
        if (node == null) {
            return;
        }
        process(node.left, listNode);
        listNode.add(node);
        process(node.right, listNode);
    }
}
