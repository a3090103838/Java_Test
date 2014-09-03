package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootLeafNum {

	public void helper(List<Integer> list, int fromFather, TreeNode cur){
		if(cur==null) 
			return;
		
		int curVal = fromFather*10 + cur.val;
		if(cur.left==null && cur.right==null){
			list.add(curVal);
		}
		else{
			helper(list, curVal, cur.left);
			helper(list, curVal, cur.right);
		}
	}
	
    public int sumNumbers(TreeNode root) {
    	if(root==null) 
    		return 0;
    	
    	List<Integer> list = new ArrayList<Integer>();
    	helper(list, 0, root);
    	int result=0;
    	for(int i: list) result+=i;
    	
    	return result;
    }
	
	public static void main(String[] args) {

	}

}
