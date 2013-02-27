package com.wtj.patpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Pat1005 {

	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		
		Stack<String> sumstack = new Stack<String>();
		
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int sum = 0;
		
		if(num==0)
			System.out.println("zero");
		
		while(num!=0)
		{
			sum += num%10;
			num = num/10;
		}
		
		while(sum!=0)
		{
			sumstack.push(map.get(sum%10));
			sum = sum/10;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!sumstack.empty())
		{
			sb.append(sumstack.pop()+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb.toString());
	}

}
