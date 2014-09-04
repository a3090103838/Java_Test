package com.leetcode;

public class TreeToList {
	
	public void helper(TreeNode root, TreeNode cur){
		cur.right = root;
		helper(root.left, cur.right);
		helper(root.right, cur.right);
	}
	
    public void flatten(TreeNode root) {
        
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
