package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTravesal {
	
	public List<List<Integer>> reverse(List<List<Integer>> list){
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		for(List<Integer> item: list){
			stack.push(item);
		}
		list.clear();
		
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		
		return list;
	}
	
	public void putChildIn( Queue<TreeNode> q, TreeNode root){
		if(root.left!=null) q.offer(root.left);
		if(root.right!=null) q.offer(root.right);
	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root!=null)
        	q1.add(root);
        Queue<TreeNode> cur = q1;
        Queue<TreeNode> other = q2;
        
        while(!cur.isEmpty()){
        	List<Integer> list = new ArrayList<Integer>();
        	
	        while(!cur.isEmpty()){
	        	TreeNode item = cur.poll();
	        	list.add(item.val);
	        	putChildIn(other, item);
	        }
        	
	        res.add(list);
        	Queue<TreeNode> tmp = cur;
        	cur = other;
        	other = tmp;
        }
		return reverse(res);     
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
