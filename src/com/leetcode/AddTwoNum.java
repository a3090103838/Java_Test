package com.leetcode;

public class AddTwoNum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode res = new ListNode(0);
    	ListNode current = res;
    	int carry = 0;
    	
		while(l1!=null&&l2!=null){
			int sum = l1.val + l2.val + carry;
			int cur = sum%10;
			carry = sum/10;
			current.next = new ListNode(cur);
			current = current.next; //这步开始忘了，死循环
			l1 = l1.next;//这步开始也忘了，无法终止
			l2 = l2.next;
		}
		
		while(l1!=null){
			int sum = l1.val + carry;
			int cur = sum%10;
			carry = sum/10;
			current.next = new ListNode(cur);
			current = current.next;
			l1 = l1.next;
		}
		
		while(l2!=null){
			int sum = l2.val + carry;
			int cur = sum%10;
			carry = sum/10;
			current.next = new ListNode(cur);
			current = current.next;
			l2 = l2.next;
		}
		
		if(carry==1) current.next = new ListNode(1); //特殊情况要考虑周全，最后一步的carry
		
		return res.next;
    }
	
	public static void main(String[] args) {
		
	}

}
