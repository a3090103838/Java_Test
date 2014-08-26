package com.leetcode;

public class BuyStock {
    public int maxProfit(int[] prices) {
    	int[] diff = new int[prices.length];
    	
    	for(int i=1; i<prices.length;i++)
    		diff[i] = prices[i]- prices[i-1];
    	
    	int max = 0;
    	int sum = 0;
    	
    	for(int i=1; i<diff.length;i++){
    		sum+=diff[i];
    		if(sum>max) max = sum;
    		if(sum<0) sum=0;
    	}
		return max;        
    }
	
	public static void main(String[] args) {

	}

}
