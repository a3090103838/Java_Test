package com.leetcode;

public class MedianOfTwoSortedArray {

	public int helper(int A[], int B[], int aIter, int bIter, int k){
		if(A.length==0 && B.length==0) return -1;
		if(A.length==0) return median(B);
		if(B.length==0) return median(A);
		
		if(k<=1) return Math.min(A[aIter], B[bIter]);
		
		if(A[aIter + k/2-1] <= B[bIter + k/2-1])
			return helper(A, B, aIter+k/2, bIter, k/2);
		else
			return helper(A, B, aIter, bIter+k/2, k/2);
	}
	
	public int median(int[] A){
		
		return A[A.length/2];
	}
	
    public double findMedianSortedArrays(int A[], int B[]) {
		return helper(A, B, 0, 0, (A.length+B.length)/2);    
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
