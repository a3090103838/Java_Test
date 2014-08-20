package com.leetcode;

public class DecodeWays {

	public static int addNeib(int a, int b){
		return a*10+b;
	}
	
	public static int gao(int[] a){
		if(a==null) return 0;
		if(a.length==0) return 0;
		int[] f = new int[a.length];

		if(a[0] >0 && a[0]<10)
			f[0] = 1;
		if(addNeib(a[0],a[1])>9 && addNeib(a[0],a[1])<27)
			f[1] = f[0]+1;
		
		for(int i=2;i<a.length;i++){
			if(f[i-2]==0 &&f[i-1]==0 )
				f[i]=0;
			else if(f[i-1] > 0 && a[i] >0 && a[i]<10)
				f[i] += f[i-1]+1;
			else if(f[i-2] > 0 && addNeib(a[i-2], a[i-1])>9 && addNeib(a[i-2], a[i-1])<27 )
				f[i] += f[i-2]+1;
		}
			
		return f[a.length-1];
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		System.out.println(gao(a));
	}

}
