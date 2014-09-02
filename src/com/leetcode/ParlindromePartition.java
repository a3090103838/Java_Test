package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ParlindromePartition {
	
    public List<List<String>> partition(String s) {
        boolean [][] f = genDpArray(s);
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> preRes = new ArrayList<String>();
        helper(f, 0, preRes, res, s);
        
		return res;
    }
    
    public void helper(boolean[][] f, int start, List<String> preRes, List<List<String>> res, String s){
    	if(start==s.length()) {
    		List<String> resItem = new ArrayList<String>();
    		resItem.addAll(preRes);
    		res.add(resItem); 
    		return;
    		}
    	
    	for(int i=start;i<s.length();i++){
    		if(f[start][i]==true){
    			preRes.add(s.substring(start, i+1));
    			helper(f, i+1, preRes, res, s);
    			preRes.remove(preRes.size()-1);
    		}
    	}
    }
    

	private boolean[][] genDpArray(String s) {
		char[] cs = s.toCharArray();
		
		boolean[][] f = new boolean[cs.length][cs.length];
		
		for(int i=cs.length-1;i>=0;i--){
			for(int j=i;j<cs.length;j++){
				f[i][j] = false;
				if(i==j)
					f[i][j] = true;
				else if(i+1==j)
					f[i][j] = cs[i]==cs[j];
				else
					f[i][j] = f[i+1][j-1] && cs[i]==cs[j];
			}
		}
		return f;
	}

	public static void main(String[] args) {
		ParlindromePartition pp = new ParlindromePartition();
		System.out.println(pp.partition("aab"));
	}

}
