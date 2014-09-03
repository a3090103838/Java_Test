package com.leetcode;

public class MinTreDepth {

    public int minDepth(TreeNode root) {
        if(root==null) 
        	return 0;
        else if(root.left==null && root.right==null)
        	return 1;
        else{
        	int left = minDepth(root.left);
        	int right = minDepth(root.right);
        	
        	return min(left, right) + 1;
        }
    }
	
	private int min(int left, int right) {
		if(left==0) return right;
		if(right==0) return left;
		return left<right?left:right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
