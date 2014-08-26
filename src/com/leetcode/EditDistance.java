package com.leetcode;

public class EditDistance {

	
	public int helper(char[] a, char[] b, int aIndex, int bIndex){
		if(aIndex==a.length) return b.length-bIndex;
		if(bIndex==b.length) return a.length-aIndex;
		
		if(a[aIndex]==b[bIndex])
			return helper(a, b, aIndex+1, bIndex+1);
		else
			return min(helper(a, b, aIndex+1, bIndex+1), helper(a, b, aIndex+1, bIndex), helper(a, b, aIndex, bIndex+1)) +1;
	}
	
    private int min(int a, int b, int c) {
		if(a<b)
			return a<c?a:c;
		else
			return b<c?b:c;
	}

	public int minDistance(String word1, String word2) {
        return helper(word1.toCharArray(),	 word2.toCharArray(), 0, 0);
    }
	
	public static void main(String[] args) {

	}

}
