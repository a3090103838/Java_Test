package com.leetcode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
    	if(head==null || head.next==null) return head;
    	if(head.next!=null && head.next.next==null){
    		if(head.val>head.next.val){
    			head.next.next = head;
    			ListNode newHead = head.next;
    			head.next=null;
    			return newHead;
    		}
    		else
    			return head;
    	}
    	
    	ListNode first = head;
    	ListNode second = head.next;
    	ListNode cur = second.next;
    	
    	while(cur!=null){
    		ListNode tmp = cur.next;
    		while(second!=cur){
    			if(cur.val<first.val){
    				head = cur;
    				head.next = first;
    			}
    			else if(cur.val<second.val){
    				first.next = cur;
    				cur.next = second;
    			}
    			
    			first = second;
    			second = second.next;
    		}
    		cur = tmp;
    	}
    	
		return head;        
    }
	
	public static void main(String[] args) {

	}

}
