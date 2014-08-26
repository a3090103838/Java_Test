package com.leetcode;

public class ArrayToBST {

	public TreeNode helper(int[] num, int start, int end){
		if(start>end) return null;
		
		int mid = (start + end)/2;
		TreeNode res = new TreeNode(num[mid]);
		res.left = helper(num, start, mid-1);
		res.right = helper(num, mid+1, end);
		
		return res;
	}
	
    public TreeNode sortedArrayToBST(int[] num) {
		return helper(num, 0, num.length-1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
