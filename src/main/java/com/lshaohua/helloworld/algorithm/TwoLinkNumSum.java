package com.lshaohua.helloworld.algorithm;

public class TwoLinkNumSum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        int sum = l1.val + l2.val;
        head.val = sum % 10;
        if (sum >= 10) {
            if (l1.next == null) {
                l1.next = new ListNode(sum / 10);
            } else {
                l1.next.val += sum / 10;
                ListNode tmp = l1.next;
                while (tmp != null && tmp.val >= 10) {
                    tmp.val -= 10;
                    if (tmp.next == null) {
                        tmp.next = new ListNode(1);
                    } else {
                        tmp.next.val += 1;
                    }
                    tmp = tmp.next;
                }
            }
        }
        head.next = addTwoNumbers(l1.next, l2.next);
        return head;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode listNode = getListNode(l1, l2);
        handleListNode(listNode);
        return listNode;
    }

    private static ListNode getListNode(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        head.val = l1.val + l2.val;
        head.next = addTwoNumbers2(l1.next, l2.next);
        return head;
    }

    private static void handleListNode(ListNode listNode) {
        while (listNode != null ) {
            if (listNode.val >= 10) {
                listNode.val -= 10;
                if (listNode.next == null) {
                    listNode.next = new ListNode(1);
                } else {
                    listNode.next.val += 1;
                }
            }
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
