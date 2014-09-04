package com.leetcode;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
    	String[] dirs = path.split("/");
    	Stack<String> stack = new Stack<String>();
    	
    	for(String dir: dirs){
    		if(dir.equals("") || dir.equals("."))
    			continue;
    		else if(dir.equals("..")){
    			if(!stack.empty())
    				stack.pop();
    		}
    		else{
    			stack.push(dir);
    		}
    	}
    	
    	String res = "/";
    	for(String item: stack){
    		res += item+"/";
    	}
    	if(res.length()>1)
    		return res.substring(0, res.length()-1);      
    	else
    		return res;
    }
	
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/a/./b/../../c/"));
	}

}
