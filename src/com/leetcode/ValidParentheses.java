package com.leetcode;

import java.util.Stack;

public class ValidParentheses {

	public String[] splitString(String s){
		String[] res = new String[s.length()];
		for(int i=0; i<res.length;i++)
			res[i] = s.substring(i, i+1);
		return res;
	}
	
	public boolean isValid(String s){
		Stack<String> stack = new Stack<String>();
		
		String[] a = splitString(s);
		for(String item: a){
			if("([{".contains(item))
				stack.push(item);
			if(")]}".contains(item)){
				if(!stack.empty() && ")]}".indexOf(item)=="([{".indexOf(stack.peek())){
					stack.pop();
				}
				else
					return false;
			}
		}	
		return stack.empty();
	}
	
	public static void main(String[] args) {
		String s = "([)]";
		ValidParentheses vp = new ValidParentheses();
		System.out.println("result is :" + vp.isValid(s));
	}

}
