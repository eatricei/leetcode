package com.swj.hard;

/**
 * @author swj
 * @date 2018/2/10
 */
public class MergeSortedLists {

    /**
     * 分治策略
     * @param lists 排好序的ListNode数组
     * @return  返回合并的ListNode
     */
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        return mergeSortedLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeSortedLists(ListNode[] lists, int start, int end){
        if (end == start){
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode left = mergeSortedLists(lists, start, mid);
        ListNode right = mergeSortedLists(lists, mid + 1, end);
        return mergeTwoSortedList(left, right);
    }

    private ListNode mergeTwoSortedList(ListNode left, ListNode right){
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;
        while (left != null && right != null){
            if (left.val <= right.val){
                tmp.next = new ListNode(left.val);
                left = left.next;
            }else {
                tmp.next = new ListNode(right.val);
                right = right.next;
            }
            tmp = tmp.next;
        }
        if (left == null){
            tmp.next = right;
        }else {
            tmp.next = left;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        new MergeSortedLists().mergeKLists(new ListNode[]{null});
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}