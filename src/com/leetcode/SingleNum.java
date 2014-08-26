package com.leetcode;

public class SingleNum {

    public int singleNumber(int[] A) {
    	int res = 0;
    	for(int a: A)res^=a;
		return res;   
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
