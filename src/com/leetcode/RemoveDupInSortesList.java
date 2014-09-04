package com.leetcode;

public class RemoveDupInSortesList {

    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null || head.next==null) return head;
    	
    	ListNode cur = head;
    	ListNode next = head.next;
    	
    	while(cur!=null){
    		while(next!=null && next.val==cur.val) 
    			next = next.next;
    		cur.next = next;
    		cur = next;
    		if(cur!=null)
    			next = cur.next;
    	}
    	
		return head;        
    }
	
	public static void main(String[] args) {

	}

}
