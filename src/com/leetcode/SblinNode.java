package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

public class SblinNode {

	public void putChildIn( Queue<TreeLinkNode> q, TreeLinkNode root){
		if(root.left!=null) q.offer(root.left);
		if(root.right!=null) q.offer(root.right);
	}
	
    public void connect(TreeLinkNode root) {
    	if(root==null) return;
        Queue<TreeLinkNode> q1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> q2 = new LinkedList<TreeLinkNode>();
        
        q1.add(root);
        Queue<TreeLinkNode> cur = q1;
        Queue<TreeLinkNode> other = q2;
        
        while(!cur.isEmpty()){
        	TreeLinkNode head = cur.poll();
        	putChildIn(other, head);
        	
        	while(!cur.isEmpty()){
        		head.next = cur.poll();
        		putChildIn(other, head.next);
        		head = head.next;
        	}
        	
        	Queue<TreeLinkNode> tmp = cur;
        	cur = other;
        	other = tmp;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
