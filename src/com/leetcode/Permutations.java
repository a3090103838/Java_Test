package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

	public void helper(List<List<Integer>> res, List<Integer> preRes, Set<Integer> set){
		if(set.isEmpty()){
			List<Integer> cur = new ArrayList<Integer>();
			for(Integer num: preRes) cur.add(num);
			res.add(cur);
		}
		else{
			Integer[] numArray = set.toArray(new Integer[0]);
			for(Integer num: numArray){
				preRes.add(num);
				set.remove(num);
				helper(res, preRes, set);
				set.add(num);
				preRes.remove(preRes.size()-1);
			}	
		}
	}
	
    public List<List<Integer>> permute(int[] num) {
    	List<Integer> preRes = new ArrayList<Integer>();
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Set<Integer> set = new HashSet<Integer>();
    	for(int n: num) set.add(n);
    	
    	helper(res, preRes, set);
    	
		return res;       
    }
    
	public static void main(String[] args) {
		Permutations mi = new Permutations();
		System.out.println(mi.permute(new int[] {1,2,3}));
	}
}
