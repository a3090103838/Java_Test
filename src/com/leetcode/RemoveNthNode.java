package com.leetcode;

public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode pre = head;
    	ListNode ahead = head;
    	for(int i=1;i<=n;i++) ahead = ahead.next;
    	
    	while(ahead!=null){
    		pre = pre.next;
    		ahead = ahead.next;
    	}
    	ListNode target = pre.next;
    	if(target!=null)
    		pre.next = target.next;
    	
		return head;       
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
