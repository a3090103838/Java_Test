package com.wtj.algorithm;

import java.util.Scanner;

public class BinarySearch {


	public static int binarySearch(int [] a,int x)
	{
		if(a==null||a.length<1)
			return -1;
		
		int start = 0;
		int end = a.length-1;
		while(start<=end)
		{
			int mid = (start + end)/2; 
			System.out.println("start:"+start+"end:"+end+"mid:"+mid);
			if(a[mid]==x)
			{
				return mid;
			}
			else if(a[mid]<x)
			{
				start = mid+1;
			}
			else
			{
				end = mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int [] a = new int[10];
		for(int i = 0; i<a.length;i++)
		{
			a[i] = i*10+(int)(Math.random()*10);
			System.out.print(a[i]+",");
		}
		
		System.out.println();
		
		while(true){
			int x = new Scanner(System.in).nextInt();
			System.out.println(binarySearch(a, x));
		}
	}
}
