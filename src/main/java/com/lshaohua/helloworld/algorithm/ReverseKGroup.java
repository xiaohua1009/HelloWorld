package com.lshaohua.helloworld.algorithm;

public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(reverseKGroup(listNode1, 2).toString());
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        int num = 0;
        // 下一个group的头节点,用来记录下个group处理（reverse）完后的tail节点，头节点在反转之后会变为尾节点，以便🆚后续group进行链接
        ListNode start = head;
        // 当前处理完group的尾节点，需通过tail.next链接下一个处理（reverse）完的group
        ListNode tail = dummy;
        while (current != null) {
            if (num == k - 1) {
                ListNode tmp = current.next;
                current.next = null;
                ListNode reverse = reverse(start);
                tail.next = reverse;
                tail = start;

                start.next = tmp;
                start = tmp;
                current = tmp;
                num = 0;
                continue;
            }
            current = current.next;
            num++;
        }

        return dummy.next;
    }

    public static ListNode reverse(ListNode list) {
        ListNode head = null;
        ListNode point = list;
        while(point != null) {
            ListNode tmp = point.next;
            point.next = head;
            head = point;
            point = tmp;
        }
        return head;
    }
}
