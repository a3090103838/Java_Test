package com.leetcode;

import java.util.Arrays;
import java.util.List;

public class ReverseString {
	
	public String reverseWords(String s) {
		if(s.equals("")) return s;
		List<String> list = Arrays.asList(s.split(" "));
		StringBuffer sb = new StringBuffer();
		for(String item: list){
			if(item!=" "&&item!=""&&item.length()>0)
				sb.append(reverseWord(item)+" ");
		}
		
		if(sb.length()==0)
			return "";
		return reverseWord(sb.toString()).substring(1);
    }
	
	public static void swap(char[] a, int i, int j){
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
    public  String reverseWord(String s) {
    	char[] a = s.toCharArray();
    	int start = 0;
    	int end = a.length-1;
    	while(start<end){
    		swap(a, start++, end--);
    	}
    	
    	return new String(a);
    }
  
   
    public static void main(String[] args){
    	ReverseString test = new ReverseString();
    	System.out.println(test.reverseWords("abc bcd def"));
    	System.out.println(test.reverseWords(" 1"));
    }
}

