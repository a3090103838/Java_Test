package com.leetcode;

public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        int totalIndex = m+n-1;
        int aIndex = m-1;
        int bIndex = n-1;
        
        while(aIndex>=0 && bIndex>=0){
        	if(A[aIndex]>=B[bIndex])
        		A[totalIndex--] = A[aIndex--];
        	else
        		A[totalIndex--] = B[bIndex--];
        }
        
        while(aIndex>=0){
        	A[totalIndex--] = A[aIndex--];
        }
        
        while(bIndex>=0){
        	A[totalIndex--] = B[bIndex--];
        }
    }
	
	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		msa.merge(new int[]{0, 3}, 1,new int[] {1}, 1);
	}

}
