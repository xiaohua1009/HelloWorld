package com.lshaohua.helloworld.algorithm;

public class _92ReverseBetween {

    public static void main(String[] args) {

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int index = 0;
        ListNode cur = dummy;
        ListNode leftPreNode = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode rightNextNode = null;
        while (cur.next != null) {
            index++;
            if (index == left) {
                leftPreNode = cur;
                leftNode = cur.next;
            }
            if (index == right) {
                rightNode = cur.next;
                rightNextNode = cur.next.next;
            }
            cur = cur.next;
        }
        while (leftNode != rightNode) {
            ListNode tmp = leftNode.next;
            leftNode.next = rightNextNode;
            rightNextNode = leftNode;
            leftNode = tmp;
        }
        rightNode.next = rightNextNode;
        leftPreNode.next = rightNode;
        return dummy.next;
    }
}
