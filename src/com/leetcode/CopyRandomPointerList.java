package com.leetcode;

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
	@Override
	public String toString() {
		String nextStr = "";
		String randomStr = "";
		if(next!=null)
			nextStr = String.valueOf(next.label);
		if(random!=null)
			randomStr = String.valueOf(random.label);
		return "RandomListNode [label=" + label + ", next=" + nextStr
				+ ", random=" + randomStr + "]";
	}
     
 };

public class CopyRandomPointerList {

    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null) return null;
    	
    	RandomListNode iter = head;
    	while(iter!=null){
    		RandomListNode next = iter.next;
    		iter.next = new RandomListNode(iter.label);
    		iter.next.next = next;
    		iter = next;
    	}
    	
    	iter = head;
    	RandomListNode newHead = head.next;
    	while(iter!=null){
    		RandomListNode newIter = iter.next;
    		newIter.random = iter.random==null?null:iter.random.next;
    		iter.next = newIter.next;
    		newIter.next = iter.next==null?null:iter.next.next;
    		iter = iter.next;
    	}
    	
		return newHead;     
    }
    
    public static void printList(RandomListNode list){
    	while(list!=null){
    		System.out.println(list);
    		list = list.next;
    	}
    	
    	System.out.println();
    }
	
	public static void main(String[] args) {
		CopyRandomPointerList cr = new CopyRandomPointerList();
		RandomListNode list = new RandomListNode(0);
		list.next = new RandomListNode(1);
		list.next.next = new RandomListNode(2);
		list.random = list.next.next;
		
		RandomListNode copied = cr.copyRandomList(list);
		printList(copied);
		printList(list);
		System.out.println(copied.random);
		System.out.println(list==copied);
	}

}
