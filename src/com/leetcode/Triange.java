package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triange {

	public int min(int a, int b){
		return a<=b?a:b;
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		Integer[][] a = parse(triangle);
		int length = triangle.size();
		for(int i=length-2; i>=0; i--){
			for(int j=0; j<=i;j++){
				a[i][j] = min(a[i+1][j], a[i+1][j+1]) + a[i][j];
			}
		}
		return a[0][0];
	}
	
	public Integer[][]  parse(List<List<Integer>> listOfList){
		int length = listOfList.size();
		Integer[][]a = new Integer[length][length];
		for(int i=0;i<listOfList.size();i++)
			for(int j=0;j<listOfList.get(i).size();j++)
				a[i][j] = listOfList.get(i).get(j);
		return a;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		
		Triange t = new Triange();
		System.out.println(t.minimumTotal(triangle));

	}

}
