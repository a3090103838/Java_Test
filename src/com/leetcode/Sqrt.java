package com.leetcode;

public class Sqrt {

	public static double abs(double n){
		return n>0?n:-n;
	}
	
	public static double sqrt(int x){
		if(x<=0) return 0;
		double left = 1;
		double right = x/2;
		double mid = (left + right)/2;
		
		while(abs(mid*mid-x) > 0.000001){
			System.out.println(mid);
			if(mid*mid > x){
				right = mid;
			}
			else{
				left = mid;
			}
			
			mid = (left + right)/2;
		}
		
		return mid;
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt(35));
	}

}
