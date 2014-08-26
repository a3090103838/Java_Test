package com.leetcode;

public class NumOfTree {

    public int numTrees(int n) {
    	int[][] f = new int[n+2][n+2];
    	
    	for(int i=n+1;i>=0;i--){
    		for(int j=0;j<=n+1;j++){
    			if(i==(n+1) || j==(n+1) || i==0 || j==0){
    				f[i][j] = 1;
    			}else if(j<=i) 
    				f[i][j] = 1;
    			else{
    				int sum=0;
    				for(int k=i;k<=j;k++){
    					sum+=f[i][k-1]*f[k+1][j];
    				}
    				f[i][j] = sum;
    			}
    		}
    	}
    	
    	return f[1][n];
    }
	
	public static void main(String[] args) {
		NumOfTree not = new NumOfTree();
		System.out.println(not.numTrees(2));

	}

}
