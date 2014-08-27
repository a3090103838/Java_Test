package com.leetcode;

public class ClimbStair {

    public int climbStairs(int n) {
    	if(n<=2) return n;
    	int first = 1;
    	int second = 2;
    	
    	for(int i=3; i<=n;i++){
    		int tmp = second;
    		second = first + second;
    		first = tmp;
    	}
    	return second;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
