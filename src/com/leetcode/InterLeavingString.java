package com.leetcode;

public class InterLeavingString {

    public boolean isInterleave(String os1, String os2, String os3) {
    	if(os1.length()+os2.length()!=os3.length()) return false;
    	char[] s1 = (" "+os1).toCharArray();
    	char[] s2 = (" "+os2).toCharArray();
    	char[] s3 = (" "+os3).toCharArray();
    	boolean[][] f = new boolean[s1.length][s2.length];
    	f[0][0] = true;
    	
    	for(int i=1;i<s1.length;i++){f[i][0] = false; f[i][0] = s1[i]==s3[i] && f[i-1][0];}
    	for(int j=1;j<s2.length;j++){f[0][j] = false; f[0][j] = s2[j]==s3[j] && f[0][j-1];}
    	
    	for(int i=1;i<s1.length;i++){
    		for(int j=1;j<s2.length;j++){
    			f[i][j] = false;
    			if(s1[i]==s3[i+j]){
    				f[i][j] = f[i-1][j] || f[i][j];
    			}
    			if(s2[j]==s3[i+j]){
    				f[i][j] = f[i][j-1] || f[i][j];
    			}
    		}
    	}
    	
		return f[s1.length-1][s2.length-1];       
    }
	
	public static void main(String[] args) {
		InterLeavingString ils = new InterLeavingString();
		System.out.println(ils.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

}
