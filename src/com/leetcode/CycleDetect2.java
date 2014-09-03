package com.leetcode;

public class CycleDetect2 {

	
	public ListNode getNodeOnCycle(ListNode head) {
		ListNode once = head;
		ListNode twice = head;
		
		while(twice!=null){			
			once = once.next;
			twice = twice.next;
			if(twice!=null)
				twice = twice.next;
			else
				twice=null;
			
			if(once==twice&&once!=null)
				return once;
		}
		
		return null;
    }
	
    public ListNode detectCycle(ListNode head) {
    	ListNode onCycle = getNodeOnCycle(head);
    	if(onCycle==null)
    		return onCycle;
    	else{
    		ListNode cycleHead = onCycle.next;
    		onCycle.next = null;
    		return getFirstCommonNode(head, cycleHead);
    	}    
    }
	
	private ListNode getFirstCommonNode(ListNode a, ListNode b) {
		int aCount = 0;
		int bCount = 0;
		ListNode aiter = a;
		ListNode biter = b;
		
		while(aiter!=null){aCount++; aiter = aiter.next;}
		while(biter!=null){bCount++; biter = biter.next;}
		if(aCount<bCount) {ListNode tmp = a; a = b; b = tmp;}
		for(int i=1;i<=Math.abs(aCount-bCount);i++){
			a = a.next;
		}
		
		while(a!=b){a = a.next; b = b.next;}
		
		return a;
	}

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		first.next = new ListNode(2);
		first.next.next = first;
		
		CycleDetect2 cd = new CycleDetect2();
		System.out.println(cd.detectCycle(first));

	}

}
