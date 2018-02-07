package com.swj.medium;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Given n will always be valid.Try to do this in one pass.
 * @author swj
 * @create 2018/2/6
 */
public class RemoveNthNodeFromEndOfList {
    /**
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp;
        ListNode second = temp;
        for (int i = 0; i < n + 1; i++){
            first = first.next;
        }

        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return temp.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}