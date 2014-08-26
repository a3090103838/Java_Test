package com.leetcode;

public class SortList {
	
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

    public ListNode sortList(ListNode head) {
    	if(head==null || head.next==null) return head;
    	
        ListNode secondHalf = splitList(head);
        ListNode first = sortList(head);
        ListNode second = sortList(secondHalf);
        ListNode newhead = merge(first, second);
        return newhead;
    }
	
	private ListNode merge(ListNode first, ListNode second) {
		ListNode res = new ListNode(0);
		ListNode cur = res;
		
		while(first!=null && second!=null){
			if(first.val<=second.val){
				cur.next = first;
				first = first.next;
				cur = cur.next;
			}
			else{
				cur.next = second;
				second = second.next;
				cur = cur.next;
			}
		}
		
		while(first!=null){
			cur.next = first;
			first = first.next;
			cur = cur.next;
		}
		
		while(second!=null){
			cur.next = second;
			second = second.next;
			cur = cur.next;
		}
		
		return res.next;
	}

	public static void main(String[] args) {
		SortList sl = new SortList();
		ListNode root = new ListNode(1);
		root.next = new ListNode(0);
		System.out.println(sl.sortList(root));
	}

}
