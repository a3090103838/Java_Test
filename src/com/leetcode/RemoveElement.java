package com.leetcode;

public class RemoveElement {

    public int removeElement(int[] A, int elem) {
    	if(A==null || A.length==0) return 0;
    	
        int left = 0;
        int right = A.length-1;
        
        for(;;){
        	while(left<A.length && A[left]!=elem) left++;
        	while(right>=0 && A[right]==elem) right--;
        		
        	if(left>=right) break;
        	swap(A, left, right);
        }
        
        return left;
    }
	
	private void swap(int[] A, int left, int right) {
		int tmp = A[left];
		A[left] = A[right];
		A[right] = tmp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
