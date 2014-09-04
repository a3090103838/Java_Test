package com.leetcode;

import java.util.Stack;

public class AddBinary {

    public String addBinary(String a, String b) {
    	int aIter = a.length()-1;
    	int bIter = b.length()-1;
    	Stack<String> stack = new Stack<String>();
    	int carry = 0;
    	
    	while(aIter>=0&&bIter>=0){
    		int cur = Integer.valueOf(""+a.charAt(aIter--)) + Integer.valueOf(""+b.charAt(bIter--)) + carry;
    		stack.push(String.valueOf(cur%2));
    		carry = cur/2;
    	}
    	
    	while(aIter>=0){
    		int cur = carry + Integer.valueOf(""+a.charAt(aIter--)) ;
    		stack.push(String.valueOf(cur%2));
    		carry = cur/2;
    	}
    	
    	while(bIter>=0){
    		int cur = carry + Integer.valueOf(""+b.charAt(bIter--)) ;
    		stack.push(String.valueOf(cur%2));
    		carry = cur/2;
    	}
    	
    	if(carry!=0) stack.push(String.valueOf(carry));
		return stackToStr(stack);       
    }
	
	public String stackToStr(Stack<String> stack){
		StringBuilder sb = new StringBuilder();
		while(!stack.empty()){
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("1010", "1011"));

	}

}
