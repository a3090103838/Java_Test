package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public void helper(int cur, int[] candidates, int target, List<List<Integer>> res, List<Integer> preRes){
		if(target==0){
			List<Integer> list = new ArrayList<Integer>(preRes);
			res.add(list);
			return;
		}
		else{
			if(cur>candidates.length-1 || (candidates[cur]>target && target!=0)) 
				return;
		}
		
		for(int i=0;i*candidates[cur]<=target;i++){
			for(int j=0;j<i;j++) {
				preRes.add(candidates[cur]);
			}
			helper(cur+1, candidates, target-i*candidates[cur], res, preRes);
			for(int j=0;j<i;j++)  
				preRes.remove(preRes.size()-1);
		}
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<Integer> preRes = new ArrayList<Integer>();
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	 Arrays.sort(candidates);
    	
    	helper(0, candidates, target, res, preRes);
		return res;       
    }
	
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(new int[] {1}, 1));

	}

}
