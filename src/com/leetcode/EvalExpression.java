package com.leetcode;

import java.util.Stack;

public class EvalExpression {

	public int calculate(int left, int right, String token){
		switch(token.charAt(0)){
		case '+':  return left + right;
		case '-':  return left - right;
		case '*':  return left * right;
		case '/':  return left / right;
		default : return -1;
		}
	}
	
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        
        for(String token: tokens){
        	if(token.equals("+") ||token.equals("-") ||token.equals("*") ||token.equals("/")){
        		int right = Integer.valueOf(stack.pop());
        		int left = Integer.valueOf(stack.pop());
        		stack.push(String.valueOf(calculate(left, right, token)));
        	}
        	else{
        		stack.push(token);
        	}
        }
        
        return Integer.valueOf(stack.pop());
    }
	
	public static void main(String[] args) {
		String[] a = {"4", "13", "5", "/", "+"};
		
		EvalExpression ee = new EvalExpression();
		System.out.println(ee.evalRPN(a));
	}

}
