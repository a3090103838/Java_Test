package com.leetcode;

import java.math.BigInteger;

public class UniquePath {

	public int conbineNum(int down, int up){
		BigInteger res = new BigInteger(String.valueOf("1"));
		for(int i=0;i<=up-1;i++){
			res =  res.multiply(new BigInteger(String.valueOf(down-i)));
		}
		
		for(int i=1;i<=up;i++)
			res = res.divide(new BigInteger(String.valueOf(i)));
		
		return Integer.valueOf(res.toString());
	}
	
    public int uniquePaths(int m, int n) {
        return conbineNum(m+n-2, m-1);
    }
	
	public static void main(String[] args) {
		UniquePath up = new UniquePath();
		System.out.println(up.conbineNum(18, 9));

	}

}
