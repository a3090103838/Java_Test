package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NorepeatChar {

    public int lengthOfLongestSubstring(String s) {
    	char[] cs = s.toCharArray();
    	Set<String> set = new HashSet<String>();
    	int res = 0;
    	int sum = 0;
    	
    	for(char c: cs){
    		if(!set.contains(""+c)){
    			sum++;
    			set.add(""+c);
    		}
    		else{
    			if(sum>res)
    				res = sum;
    			sum=0;
    		}
    	}
		return 0;       
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
