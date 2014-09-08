package com.leetcode;

public class LongestCommonPrefix {

	public String helper(String[] strs, int index){
		String firStr = strs[0];
		if(index>=firStr.length()) return "";
		char first = firStr.charAt(index);
		for(String str: strs){
			if(index>=str.length() || str.charAt(index)!=first)
				return "";
		}
		
		return ""+first+helper(strs, index+1);
	}
	
    public String longestCommonPrefix(String[] strs) {
    	if(strs==null | strs.length==0) return "";
		return helper(strs, 0);
        
    }
	
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(new String[] {"abccccc", "abcccc", "ab"}));
	}

}
