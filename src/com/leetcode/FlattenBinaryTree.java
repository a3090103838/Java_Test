package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {

	public void helper(TreeNode root, List<TreeNode> list ){
		if(root==null) return;
		
		list.add(root);
		helper(root.left, list);
		helper(root.right, list);
	}
	
    public void flatten(TreeNode root) {
    	if(root==null) return;
    	
        List<TreeNode> list = new ArrayList<TreeNode>();
        helper(root, list);
        for(int i=0;i<list.size()-1;i++)
        	list.get(i).right = list.get(i+1); 
    }
	
	public static void main(String[] args) {

	}

}
