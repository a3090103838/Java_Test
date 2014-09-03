package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class ValidateBST {

	public void helper(List<TreeNode> list, TreeNode root){
		if(root==null) return;
		helper(list, root.left);
    	list.add(root);
    	helper(list, root.right);
	}
	
    public boolean isValidBST(TreeNode root) {
    	List<TreeNode> list = new LinkedList<TreeNode>();
    	helper(list, root);
    	
    	for(int i=0;i<list.size()-1;i++){
    		if(list.get(i).val>=list.get(i+1).val)
    			return false;
    	}
    	
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
