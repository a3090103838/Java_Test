package com.leetcode;

public class LongestParlindromic {
	
    public String longestPalindrome(String s) {
    	int length = s.length();
    	boolean[][] f = new boolean[length][length];
    	int max = -1;
    	int start = -1;
    	int end = -1;
    	
    	for(int i=length-1;i>=0;i--){
    		for(int j=i;j<length;j++){
    			f[i][j] = false;
    			if(i==j) 
    				f[i][j] = true;
    			else if(j==i+1) 
    				f[i][j] = s.charAt(i)==s.charAt(j);
    			else
    				f[i][j] = ( s.charAt(i)==s.charAt(j) ) && f[i+1][j-1];
    			
    			if(f[i][j] && (j-i)>max){
    				max = j-i;
    				start = i;
    				end = j;
    			}
    				
    		}
    	}
		return s.substring(start, end+1);  
    }

	public static void main(String[] args) {
		LongestParlindromic lp = new LongestParlindromic();
		System.out.println(lp.longestPalindrome("abacccc"));
	}

}
