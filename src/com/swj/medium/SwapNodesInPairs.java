package com.swj.medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * @author swj
 * @date 2018/2/25
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while (current.next != null && current.next.next != null){
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return temp.next;
    }
}
