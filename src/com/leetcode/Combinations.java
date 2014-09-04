package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public void helper( List<List<Integer>> res,  List<Integer> preRes, int[] a , int start, int k){
		if(k==0) {
			List<Integer> cur = new ArrayList<Integer>();
			for(Integer num: preRes) cur.add(num);
			res.add(cur);
			return;
		}
		
		if(start<a.length){		
			preRes.add(a[start]);
			helper(res, preRes, a, start+1, k-1);
			preRes.remove(preRes.size()-1);
			helper(res, preRes, a, start+1, k);
		}
	}
	
    public List<List<Integer>> combine(int n, int k) {
    	int[] a = new int[n+1];
    	for(int i=0;i<a.length;i++)
    		a[i] = i;
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> preRes = new ArrayList<Integer>();
    	
    	helper(res, preRes, a, 1, k);
		return res;     
    }
	
	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 2));

	}

}
