package com.lshaohua.helloworld.algorithm;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.printf(swapPairs(l1).toString());
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            ListNode node1 = node.next;
            ListNode node2 = node.next.next;
            node1.next = node2.next;
            node.next = node2;
            node2.next = node1;
            node = node1;
        }
        return dummy.next;
    }
}
