package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {

	public void postHelper(TreeNode root, List<Integer> list){
		if(root==null) return;
		
		postHelper(root.left, list);
		postHelper(root.right, list);
		list.add(root.val);
	}
	
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	postHelper(root, list);
		return list;
    }
    
	public void preHelper(TreeNode root, List<Integer> list){
		if(root==null) return;

		list.add(root.val);
		preHelper(root.left, list);
		preHelper(root.right, list);
	}
    
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	preHelper(root, list);
		return list;
    }
    
	public void inHelper(TreeNode root, List<Integer> list){
		if(root==null) return;

		inHelper(root.left, list);
		list.add(root.val);
		inHelper(root.right, list);
	}
    
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	inHelper(root, list);
		return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
