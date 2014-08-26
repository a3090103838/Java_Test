package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
    	
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<numbers.length;i++){
    		int current = numbers[i];
    		if(map.containsKey(target-current)){
    			return new int [] {map.get(target-current), i+1};
    		}
    		map.put(current, i+1);
    	}
    	
		return null;
    }
    
    public void printMap(Map<Integer,Integer> map){
    	for(Integer a: map.keySet())
    		System.out.println(a+"-"+map.get(a));
    	System.out.println();
    }
    
	public static void print_arr(int[] a){
		for(int item: a){
			System.out.print(item+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		print_arr(ts.twoSum(new int[]{0,4,3,0}, 0));
	}

}
