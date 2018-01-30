package com.swj.medium;

public class AddTwoNumbers {
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val=x;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
		ListNode answer=new ListNode(0);
		ListNode tmp = answer;
		int temp = 0;
		int sb=0;
		while(l1!=null||l2!=null){
			int val=0;
			if(l1==null){
				val = l2.val+temp;
			}else if(l2==null){
				val = l1.val+temp;
			}else{
				val = l1.val+l2.val+temp;
			}
			if(temp==1){
				temp=0;
			}
			if(val>=10){
				val%=10;
				temp+=1;
			}
			if(sb==0){
				tmp.val=val;
				sb++;
			}else{	
				tmp.next = new ListNode(val);
				tmp = tmp.next;
			}
			l1=l1==null?l1:l1.next;
			l2 = l2==null?l2:l2.next;
		}
		if(temp==1){
			tmp.next=new ListNode(1);
		}
		return answer;
	}
	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbersS(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;//这样不用创建一个sb了- -
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		ListNode answer = addTwoNumbers(l1,l2);
		System.out.println(answer.val);
	}
}
