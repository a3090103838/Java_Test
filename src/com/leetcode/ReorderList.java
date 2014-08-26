package com.leetcode;

public class ReorderList {

	public ListNode splitList(ListNode list){
		if(list==null||list.next==null) return list;
		ListNode first = list;
		ListNode second = list;
		
		while(second.next!=null && second.next.next!=null){
			first = first.next;
			second = second.next.next;
		}
		
		ListNode tmp = first;
		first = first.next;
		tmp.next = null;
		
		return first;
	}
	
	public ListNode reverse(ListNode head){
		if(head==null || head.next==null) return head;
		
		ListNode newHead = head;
		ListNode oldHead = head.next;
		newHead.next=null;
		
		while(oldHead!=null){
			ListNode tmp = oldHead.next;
			oldHead.next = newHead;
			newHead = oldHead;
			oldHead = tmp;
		}
		
		return newHead;
	}
	
    public void reorderList(ListNode head) {
    	if(head==null || head.next==null) return;
        ListNode second = splitList(head);
        second = reverse(second);
        
        head = merge(head, second);
    }
	
	private ListNode merge(ListNode head, ListNode second) {
		ListNode res = new ListNode(0);
		ListNode cur = res;
		while(head!=null && second!=null){
			cur.next = head;
			cur = cur.next;
			head = head.next;
			
			cur.next = second;
			cur = cur.next;
			second = second.next;
		}
		
		while(head!=null){
			cur.next = head;
			cur = cur.next;
			head = head.next;
		}
		
		while(second!=null){
			cur.next = second;
			cur = cur.next;
			second = second.next;
		}
		return res.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
