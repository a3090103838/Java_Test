package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

    public List<String> anagrams(String[] strs) {
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	
    	for(String str: strs){
    		char[] cs = str.toCharArray();
    		Arrays.sort(cs);
    		String sorted = new String(cs);
    		if(map.containsKey(sorted)){
    			List<String> list = map.get(sorted);
    			list.add(str);
    			map.put(sorted,list);
    		}
    		else{
    			List<String> list = new ArrayList<String>();
    			list.add(str);
    			map.put(sorted,list);
    		}
    	}
    	
    	List<String> res = new ArrayList<String>();
    	for(String key: map.keySet()){
    		if(map.get(key).size()>1)
    			res.addAll(map.get(key));
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
