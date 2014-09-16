package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GenPerentheses {
    
	public void helper(List<String> preRes, int leftNum, int rightNum, Set<String> res, Stack<String> stack){
	    if(leftNum==0 && rightNum==0 && stack.isEmpty()) {
	        res.add(mkString(preRes));
	    }
	    else if(stack.isEmpty()){
	        if(leftNum>0){
	            stack.push("(");
	            preRes.add("(");
	            helper(preRes, leftNum-1, rightNum, res, stack);
	        }
	    }
	    else{
                if(leftNum>0){
                    stack.push("(");
                    preRes.add("(");
                    helper(preRes, leftNum-1, rightNum, res, stack);
                    stack.pop();
                    preRes.remove(preRes.size()-1);
                }
                if(rightNum>0){
                    String cur = stack.pop();
                    preRes.add(")");
                    helper(preRes, leftNum, rightNum-1, res, stack);
                    preRes.remove(preRes.size()-1);
                    stack.push(cur);
                }
	    }
	}
	
    private String mkString(List<String> preRes) {
        StringBuilder sb = new StringBuilder();
        for(String item: preRes)
            sb.append(item);
        return sb.toString();
    }

    public List<String> generateParenthesis(int n) {
    	Set<String> res = new HashSet<String>();
    	List<String> preRes = new ArrayList<String>();
    	Stack<String> stack = new Stack<String>();
    	
    	helper(preRes, n, n, res, stack);
    	
		return new ArrayList<String>(res);
    }
	
	public static void main(String[] args) {
	    GenPerentheses gp = new GenPerentheses();
	    System.out.println(gp.generateParenthesis(3));
	}

}
