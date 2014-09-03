package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public boolean[] genDpList(String a, Set<String> dict){
		String tmp = ' '+ a;
		boolean[] f = new boolean[a.length()+1];
		f[0] = true;
		
		for(int i=1; i<=a.length();i++){
			for(int j=0; j<i;j++){
				if(f[j] && dict.contains(tmp.substring(j+1, i+1)))
					f[i] = f[j] && dict.contains(tmp.substring(j+1, i+1));
			}
		}
		
		return f;
	}
	
	public void helper(boolean[] f, int start, List<String> list, String preRes, Set<String> dict, String ori){
		if(start==f.length) list.add(preRes.substring(0, preRes.length()-1));
		
		for(int i=start;i<f.length;i++){
			if(dict.contains(ori.substring(start, i+1))){
				helper(f, i+1, list, preRes+ori.substring(start, i+1)+" ", dict, ori);
			}
		}
	}
	
    public List<String> wordBreak(String s, Set<String> dict) {
		boolean[] f = genDpList(s, dict);        
		List<String> res = new ArrayList<String>();
		helper(f, 1, res, "", dict, " "+s);
		
		return res;
    }
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		String a = "catsanddog";
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		WordBreak2 wb = new WordBreak2();
		System.out.println("result is :" + wb.wordBreak(a, dict));
	}

}
