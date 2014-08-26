package com.leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x; 
        next = null;
    }
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next.val + "]";
	}  
    
}

public class CycleDetect {

	public boolean hasCycle(ListNode head) {
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
				return true;
		}
		
		return false;
    }
	
    public ListNode detectCycle(ListNode head) {
		return head;
    }
	
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		first.next = new ListNode(2);
		first.next.next = first;
		
		CycleDetect cd = new CycleDetect();
		System.out.println(cd.hasCycle(first));
	}

}
