package com.leetcode;

import java.util.Stack;

public class PlusOne {

	public int[] stackToArray(Stack<Integer> stack){
		int[] res = new int[stack.size()];
		int i=0;
		while(!stack.empty()){
			res[i++] = stack.pop();
		}
		
		return res;
	}
	
    public int[] plusOne(int[] digits) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int carry = 0;
    	
      for(int i=digits.length-1;i>=0;i--){
    	  int cur = digits[i]+carry;
    	  if(i==digits.length-1)
    		  cur++;
    	  stack.push(cur%10);
    	  carry = cur/10;
      }  
      if(carry!=0)
    	  stack.push(1);
      
      return stackToArray(stack);
    }
	
    public static void printArr(int[] num){
    	for(int n: num) 
    		System.out.println(n);
    }
    
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		printArr(po.plusOne(new int[]{1,2,9}));

	}

}
