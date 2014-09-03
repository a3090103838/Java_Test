package com.leetcode;

public class SortColors {

	public void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
    public void helper(int[] A, int first, int second) {
    	if(A==null||A.length==0) return;
        int i = 0;
        int j = A.length-1;
        
        for(;;){
        	while(A[i]!=second&&(i+1)<=(A.length-1))i++;
        	while(A[j]!=first && (j-1)>=0)j--;
        	if(i>=j) break;
        
        	swap(A, i, j);
        }
    }
    
    public void sortColors(int[] A) {
    	helper(A, 0, 1);
    	helper(A, 0, 2);
    	helper(A, 1, 2);
    }
	
	public static void main(String[] args) {

	}

}
