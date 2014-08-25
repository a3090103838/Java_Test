package com.leetcode;

public class ValidPalindrom {

	public boolean helper(String s){
		char[] chars = s.toCharArray();
		int start = 0;
		int end = chars.length-1;
		while(start<end){
			if(chars[start++]!=chars[end--])
				return false;
		}
		return true;
	}
	
    public boolean isPalindrome(String s) {
    	s = s.replaceAll("[^a-zA-Z0-9]", "");
    	s = s.toLowerCase();
    	String[] words = s.split(",");
    	StringBuilder sb = new StringBuilder();
    	
    	for(String word: words)
    		if(!word.equals(""))
    			sb.append(word);
		return helper(sb.toString());       
    }
	
	public static void main(String[] args) {
		ValidPalindrom vp = new ValidPalindrom();
		System.out.println(vp.isPalindrome("1a2"));

	}

}
