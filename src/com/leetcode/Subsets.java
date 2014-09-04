package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public void helper( List<List<Integer>> res,  List<Integer> preRes, int[] S , int start){
		if(start==S.length) {
			List<Integer> cur = new ArrayList<Integer>();
			for(Integer num: preRes) 
				cur.add(num);
			res.add(cur);
			return;
		}
		
		if(start<S.length){		
			preRes.add(S[start]);
			helper(res, preRes, S, start+1);
			preRes.remove(preRes.size()-1);
			helper(res, preRes, S, start+1);
		}
	}
	
    public List<List<Integer>> subsets(int[] S) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> preRes = new ArrayList<Integer>();
    	
    	helper(res, preRes, S, 0);
		return res;  
    }
	
	public static void main(String[] args) {
		Subsets c = new Subsets();
		System.out.println(c.subsets(new int[] {4,1,0}));

	}

}
