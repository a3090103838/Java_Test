package com.leetcode;

public class Sqrt {
	
	public int sqrt(int x){
		if(x<2) return x;
		int left = 1;
		int right = x/2;
		int mid = (left + right)/2;
		
		while(left<=right){
			if(x/mid<mid){
				right = mid-1;
			}
			else if(x/mid>mid){
				left = mid+1;
			}
			else
				return mid;
			
			mid = (left + right)/2;
		}
		
		return (int) mid;
	}
	
	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(1579205274));
	}

}
