package com.lshaohua.helloworld.algorithm;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        System.out.printf(removeNthFromEnd(head, 2).toString());;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode forward = dummy;
        ListNode behind = dummy;
        for (int i = 0; i < n + 1; i++) {
            forward = forward.next;
        }
        while (forward != null) {
            forward = forward.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return dummy.next;
    }
}
