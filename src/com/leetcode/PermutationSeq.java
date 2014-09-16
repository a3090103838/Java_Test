package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PermutationSeq {

    public String getPermutation(int n, int k) {
        int[] res = new int[n+1];
        int base = 1;
        for(int i=1;i<=n;i++) base *= i;
        List<Integer> list = new LinkedList<Integer>();
        for(int i=1;i<=n;i++) list.add(i);
        
        int left = k-1;
        for(int i=1;i<=n;i++){
        	base = base/(n+1-i);
        	res[i] = list.get(left/base);
        	list.remove(left/base);
        	left = left%base;
        }
        
        int ans = 0;
        for(int i=1;i<=res.length-1;i++){
        	ans = ans*10 + res[i];
        }
        
        return String.valueOf(ans);
    }
	

	public static void main(String[] args) {
		PermutationSeq ps = new PermutationSeq();
		System.out.println(ps.getPermutation(3,2));
	}

}
