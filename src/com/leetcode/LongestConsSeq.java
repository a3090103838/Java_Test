package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsSeq {

    public int longestConsecutive(int[] num) {
    	Set<Integer> set = new HashSet<Integer>();
		for(int n: num)  set.add(n);
		
		int res = 0;
		
		for(int n:num){
			if(!set.contains(n)) continue;
			
			int sum = 1;
			set.remove(n);
			int less = n-1;
			int more = n+1;
			
			while(set.contains(less)){
				sum++;
				set.remove(less);
				less-=1;
			}
			
			while(set.contains(more)){
				sum++;
				set.remove(more);
				more+=1;
			}
			
			if(sum>res) res=sum;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		LongestConsSeq lp = new LongestConsSeq();
		System.out.println(lp.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
	}

}
