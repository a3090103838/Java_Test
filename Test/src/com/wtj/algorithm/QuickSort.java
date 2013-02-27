package com.wtj.algorithm;

public class QuickSort {
	
	public static void quicksort(int[] a , int s,int e)
	{
		//System.out.println("s:"+s+" e:"+e);
		if(s>=e)
			return;
		if(s==(e-1))
		{
			if(a[s]>a[e])
				swap(a,s,e);
			return;
		}
		
		int i = s;
		int j = e+1;
		int x = a[s];
		for(;;)
		{
			while(a[++i]<=x){}
			while(a[--j]>=x){}
			if(i<j)
				swap(a,i,j);
			else 
				break;
		}
		swap(a,s,j);
		quicksort(a, s, j-1);
		quicksort(a, j+1, e);
	}
	
	private static void swap(int[] a,int i,int j)
	{
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
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
		int[] a = new int[10];
		for(int i = 0;i<a.length;i++)
		{
			a[i] = (int)(Math.random()*100);
		}

		printArray(a);
		quicksort(a, 0, a.length-1);
		
		printArray(a);
	}

}
