package com.lshaohua.helloworld.algorithm;

import java.util.PriorityQueue;

public class MergeKLists {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode7 = new ListNode(2);

        System.out.println(mergeKLists(new ListNode[]{listNode1, listNode4, listNode7}).toString());
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) ->  Integer.compare(a.val, b.val));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode index = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            index.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            index = index.next;
        }
        return head.next;
    }

}
