package com.leetcode;

import java.util.Stack;

public class LongestParetheses {

    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        Stack<Character> stack = new Stack<Character>();
        
        int cur = 0;
        for(char c: cs){
            if(stack.isEmpty() && c==')'){
                if(cur>res) res = cur;
                cur=0;
            }
        }
        return cur;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
