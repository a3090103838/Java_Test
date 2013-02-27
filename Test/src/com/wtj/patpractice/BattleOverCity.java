package com.wtj.patpractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BattleOverCity {
	
	public static Set<Integer> getSeedSet(int seed,Map<Integer,LinkedList<Integer>> map,Set<Integer>tagset,int exc)
	{
		Set<Integer> seedset = new HashSet<Integer>();
		seedset.add(seed);
		LinkedList<Integer> list = map.get(seed);
		seedset.addAll(list);
		tagset.add(seed);
		
		Set<Integer> tmpset = new HashSet<Integer>();
		for(Integer i:seedset)
		{
			if(!tagset.contains(i)&&i!=exc)
				tmpset.addAll(getSeedSet(i,map,tagset,exc));
		}
		seedset.addAll(tmpset);
		return seedset;
	}
	
	public static void printSetList(LinkedList<HashSet<Integer>> setList)
	{
		if(setList.size()==0)
			System.out.println("null setlist");
		for(Set<Integer>set:setList)
		{
			for(Integer i:set)
				System.out.print(i+",");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int N,M;
		Map<Integer,LinkedList<Integer>>map = new HashMap<Integer, LinkedList<Integer>>();
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		
		for(int i = 0;i<M;i++)
		{
			int left,right;
			left = in.nextInt();
			right = in.nextInt();
			if(map.containsKey(left)){
				map.get(left).add(right);
			}
			else{
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(right);
				map.put(left, list);
			}
			
			if(map.containsKey(right)){
				map.get(right).add(left);
			}
			else{
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(left);
				map.put(right, list);
			}
				
		}
		Set<Integer> total = new HashSet<Integer>();
		
		for(int i = 1;i<=N;i++)
		{
			total.clear();
			for(int j = 1;j<=N;j++)
				total.add(j);
			total.remove(i);
			
			LinkedList<HashSet<Integer>>setList = new LinkedList<HashSet<Integer>>();
			while(total.size()!=0)
			{
				int seed = total.iterator().next();
				HashSet<Integer>tagset = new HashSet<Integer>();
				Set<Integer> seedset = getSeedSet(seed, map,tagset,i);
				total.removeAll(seedset);
				setList.add((HashSet<Integer>) seedset);
			}
			
			System.out.println(setList.size()-1);
			
		}
	}

}
