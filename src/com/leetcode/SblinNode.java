package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

public class SblinNode {

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> q2 = new LinkedList<TreeLinkNode>();
        
        q1.add(root);
        Queue<TreeLinkNode> cur = q1;
        Queue<TreeLinkNode> other = q2;
        
        while(!cur.isEmpty()){
        	Iterator<TreeLinkNode> iter = cur.iterator();
        	while(iter.hasNext()){
        		TreeLinkNode current = iter.next();
        		current.next = iter.next();
        	}
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
