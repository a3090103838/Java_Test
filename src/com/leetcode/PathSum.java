package com.leetcode;

public class PathSum {
    
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null) return false;
    	if(root!=null && root.left==null && root.right==null) return sum==root.val;
    	
    	return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    } 
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		PathSum ps = new PathSum();
		System.out.println(ps.hasPathSum(root, 1));

	}

}
