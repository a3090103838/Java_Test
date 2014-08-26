package com.leetcode;

public class TreeDepth {

	public int max(int a, int b){
		return a>=b?a:b;
	}
	
    public int maxDepth(TreeNode root) {
    	if(root==null) return 0;
    	return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
