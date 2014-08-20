package com.leetcode;

import java.util.Stack;

public class ValidParentheses {

	public static boolean gao(String[] a){
		Stack<String> stack = new Stack<String>();
		
		for(String item: a){
			if("([{".contains(item))
				stack.push(item);
			if(")]}".contains(item)){
				if("([{".indexOf(item)==")]}".indexOf(stack.peek()))
					stack.pop();
				else
					return false;
			}
		}
		
		return stack.empty();
	}
	
	public static void main(String[] args) {
		String[] a = {"(", "(", "{", "}", "[" , "]"};
		System.out.println("result is :" + gao(a));
	}

}
