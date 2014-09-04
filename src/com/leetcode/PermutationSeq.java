package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PermutationSeq {

    public String getPermutation(int n, int k) {
        int[] res = new int[n+1];
        List<Integer> list = new LinkedList<Integer>();
        for(int i=0;i<=n;i++) list.add(i);
        
        int left = k;
        for(int i=1;i<=n;i++){
        	res[i] = list.get(left/(n+1-i));
        	System.out.println(list.get(left/(n+1-i) +1));
        	list.remove(left/(n+1-i) +1);
        	left = k%(n+1-i);
        }
        
        int ans = 0;
        for(int i=res.length-1;i>=1;i--){
        	ans = ans*10 + res[i];
        }
        
        return String.valueOf(ans);
    }
	

	public static void main(String[] args) {
		PermutationSeq ps = new PermutationSeq();
		System.out.println(ps.getPermutation(3,5));
	}

}
