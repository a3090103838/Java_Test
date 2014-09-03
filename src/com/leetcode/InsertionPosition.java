package com.leetcode;

public class InsertionPosition {

    public int searchInsert(int[] A, int target) {
    	int start = 0;
    	int end = A.length-1;
    	
    	while(start<=end){    		
    		int mid = ( start + end )/2;
    		if(A[mid]==target)
    			return mid;
    		else if(A[mid] < target)
    			start = mid + 1;
    		else 
    			end = mid -1;
    	}
    	
		return target;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
