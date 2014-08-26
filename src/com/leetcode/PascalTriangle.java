package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

	public int[][] helper(int n){
		int[][] res = new int[n][n];
		for(int i=0; i<n;i++){
			for(int j=0;j<=i;j++){
				if(i==j || j==0) 
					res[i][j] = 1;
				else
					res[i][j] = res[i-1][j] + res[i-1][j-1] ;
			}
		}
		return res;
	}
	
	public List<List<Integer>> parse(int[][] a, int n){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		for(int i=0; i<n;i++){
			List<Integer> sublist = new ArrayList<Integer>();
			for(int j=0;j<=i;j++){
				sublist.add(a[i][j]);
			}
			res.add(sublist);
		}
		
		return res;
	}
	
    public List<List<Integer>> generate(int numRows) {
        return parse(helper(numRows), numRows);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
