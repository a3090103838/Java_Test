package com.leetcode;

public class BinaryTreeMaxPathSum {

	public int[] helper(TreeNode root){
		if(root==null)
			return new int[] {0,0};
		
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		
		int depthVal = Math.max(left[0], right[0]) + root.val;
		int maxPath = Math.max(Math.max(left[1], right[1]), root.val + left[0] + right[0]);
		return new int[] {depthVal, maxPath};
	}
	
    public int maxPathSum(TreeNode root) {
    	int[] res = helper(root);
    	if(res[1]>=0)
    		return res[1];
    	return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
