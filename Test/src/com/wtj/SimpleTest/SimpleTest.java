package com.wtj.SimpleTest;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleTest {

	public static void main(String[] args) {
		
		Queue<Integer> list = new LinkedList<Integer>();
		for(int i = 0;i<5;i++)
			list.add(i);
		for(int i =0;i<5;i++)
			System.out.print(list.poll()+",");
	}

}
