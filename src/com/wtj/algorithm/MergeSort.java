package com.wtj.algorithm;

public class MergeSort {

	public static void mergeSort(int[] a,int[] tmp,int left,int right)
	{
		if(left<right)
		{
			int mid = (left+right)/2;
			mergeSort(a, tmp, left, mid);
			mergeSort(a, tmp, mid+1, right);
			merge(a, tmp, left, mid+1, right);
		}
		else 
			return;
	}
	
	private static void merge(int[] a,int[] tmp,int ls,int rs,int re)
	{
		int le = rs-1;
		int tmpi = ls;
		int s = ls;
		while(ls<=le&&rs<=re)
		{
			if(a[ls]<=a[rs])
				tmp[tmpi++] = a[ls++];
			else
				tmp[tmpi++] = a[rs++];
		}
		
		while(ls<=le) tmp[tmpi++] = a[ls++];
		while(rs<=re) tmp[tmpi++] = a[rs++];
		
		for(int i = tmpi-1;i>=s;i--)
			a[i] = tmp[i];
	}
	
	public static void printArray(int[] a)
	{
		for(int i = 0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = new int[30];
		int[] tmp = new int[30];
		for(int i = 0;i<a.length;i++)
		{
			a[i] = (int)(Math.random()*100);
		}

		printArray(a);
		mergeSort(a,tmp, 0, a.length-1);
		
		printArray(a);
	}

}
