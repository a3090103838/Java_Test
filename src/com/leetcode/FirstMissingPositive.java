package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n: A){
        	if(n>0) 
        		set.add(n);
        }
        
        int i=1;
        for(;i<=set.size();i++){
        	if(!set.contains(i))
        		return i;
        }
        return i;
    }
	
	public static void main(String[] args) {
		FirstMissingPositive fm = new FirstMissingPositive();
		System.out.println(fm.firstMissingPositive(new int[] {3,4,2,1}));
	}

}
