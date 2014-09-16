package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {

	class Result{
		int res;

		public Result(int res) {
			super();
			this.res = res;
		}

		public int getRes() {
			return res;
		}

		public void setRes(int res) {
			this.res = res;
		}
	}
	
	public String setCharAt(String s, int index, char a){
		char[] cs = s.toCharArray();
		cs[index] = a;
		return new String(cs);
	}
	
	public void helper(String start, String end, Set<String> dict, Set<String> visited,  Result res){
		
		for(int i=0;i<start.length();i++){
			char cur = start.charAt(i);
			for(char a='a'; a<='z';a++){
				if(a!=cur){
					String newStr = setCharAt(start, i, a);
					if(newStr.equals(end)){
						int newRes = visited.size()+2;
						if(newRes<res.getRes())
							res.setRes(newRes);
					}
					if(dict.contains(newStr) && !visited.contains(newStr)){
						visited.add(newStr);
						helper(newStr, end, dict, visited, res);
						visited.remove(newStr);
					}
				}
			}
		}
	}
	
    public int ladderLength1(String start, String end, Set<String> dict) {//深度优先搜索，超时
		Result res = new Result(100000);
		Set<String> visited = new HashSet<String>();
		helper(start, end, dict, visited, res);
		return res.getRes();
    }
    
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(wl.ladderLength1("hit", "cog", dict));
	}

}
