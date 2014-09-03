package com.leetcode;

public class MaxSubarray {
    public int maxSubArray(int[] diff) {
    	if(diff.length==1) return diff[0];
    	int max = 0;
    	int sum = 0;
    	int maxMinus = -100000;
    	
    	for(int i=0; i<diff.length;i++){
    		sum+=diff[i];
    		if(sum>max) max = sum;
    		if(sum<0) sum=0;
    		if(diff[i]<=0 && diff[i]>maxMinus)
    			maxMinus = diff[i];
    	}
		return max>0?max:maxMinus;   
    }
	
	public static void main(String[] args) {

	}

}
