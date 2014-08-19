package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static Set<String> dict = new HashSet<String>();
	
	public static boolean gao(String a){
		String tmp = 'a'+ a;
		boolean[] f = new boolean[a.length()+1];
		f[0] = true;
		
		for(int i=1; i<=a.length();i++){
			for(int j=0; j<i;j++){
				if(f[j] && dict.contains(tmp.substring(j+1, i+1)))
					f[i] = f[j] && dict.contains(tmp.substring(j+1, i+1));
			}
		}
		print_arr(f);
		
		return f[a.length()];
	}
	
	public static void print_arr(boolean[] a){
		for(boolean item: a){
			System.out.print(item+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String a = "leetcode";
		dict.add("leet");
		dict.add("code");
		System.out.println("result is :" + gao(a));
	}

}
