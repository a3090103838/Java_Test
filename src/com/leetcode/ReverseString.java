package com.leetcode;

public class ReverseString {
	
	public static void swap(char[] a, int i, int j){
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
    public static void reverseWords(char[] a, int start, int end) {
    	while(start<end){
    		swap(a, start++, end--);
    	}
    }
    
    public String reverse(String s){
    	String tmp = s+' ';
    	char[] str = tmp.toCharArray();
    	reverseWords(str, 0, s.length()-1);
    	int i = 0;
    	while(str[i]==' '){i++;}
    	
    	int start = i;
    	int end = i;
    	
    	for(;;){
    		while(str[end]!=' ') end++;
    		reverseWords(str, start, end-1);
    		while(str[end]==' ') {
    			if(end==str.length-1)
    				return new String(str);
    			end++;
    		}
    		start = end;
    	}
    }
   
    public static void main(String[] args){
    	ReverseString test = new ReverseString();
    	System.out.println(test.reverse("abc bcd def"));
    }
}

