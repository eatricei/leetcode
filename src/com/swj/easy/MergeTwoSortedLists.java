package com.swj.easy;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author swj
 * @date 2018/2/7
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            temp.next = l2;
        } else {
            temp.next = l1;
        }
        return result.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}