package com.leetcode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
    	ListNode less = new ListNode(0);
    	ListNode more = new ListNode(0);
    	ListNode lessCur = less;
    	ListNode moreCur = more;
    	
    	while(head!=null){
    		if(head.val<x){
    			lessCur.next = head;
    			lessCur = lessCur.next;
    			head = head.next;
    			lessCur.next = null;   			
    		}
    		else{
    			moreCur.next = head;
    			moreCur = moreCur.next;
    			head = head.next;  
    			moreCur.next = null;
    		}    			
    	}
    	lessCur.next = more.next;
    	more.next = null;
    	
		return less.next;       
    }

	public static void main(String[] args) {

	}

}
