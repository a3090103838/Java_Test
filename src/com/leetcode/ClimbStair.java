package com.leetcode;

public class ClimbStair {

    public int climbStairs(int n) {
    	if(n<=2) return n;
		return climbStairs(n-1) + climbStairs(n)-2;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
