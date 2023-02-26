package com.ping.entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int data) {
        this.val = data;
    }

    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
