package com.leetcode;

public class RemoveDup2 {

    public ListNode deleteDuplicates(ListNode head) {
    	ListNode newHead = new ListNode(0);
    	ListNode newHeadIter = newHead;
    	ListNode cur = head;
    	ListNode next = head;
    	
    	while(cur!=null){
    		while(next.val==cur.val){
    			next = next.next;
    			if(next == null)
    				break;
    		}
    		if(cur.next == next){
    			newHeadIter.next = cur;
    			cur.next = null;
    			newHeadIter = newHeadIter.next;
    		}
    		
    		cur = next;
    	}   	 	
		return newHead.next;       
    }
	
	public static void main(String[] args) {
		RemoveDup2 rd = new RemoveDup2();
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		System.out.println(rd.deleteDuplicates(list));
	}

}
