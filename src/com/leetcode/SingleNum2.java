package com.leetcode;

public class SingleNum2 {

    public int singleNumber(int[] A) {
		int one = 0;
		int two = 0;
		int three = 0;
		
		for(int a: A){
			three = two & a;
			two = two | (one&a);
			one = one | a;
			
			one = one & ~three;
			two = two & ~three;
		}
		
		return one;
    }
	
	public static void main(String[] args) {

	}

}