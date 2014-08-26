package com.leetcode;

public class DecodeWays {

	public  int addNeib(int a, int b){
		return a*10+b;
	}
	
	public int numDecodings(String s){
		if(s==null) return 0;
		char[] sa = s.toCharArray();
		int[] a = new int[sa.length];
		
		for(int i =0;i<sa.length; i++) {
			a[i] = Integer.parseInt(""+sa[i]);
			//System.out.println(a[i]);
		}
		
		if(a.length==0) return a.length;
		if(a.length==1){
			if(a[0] >0 && a[0]<10) 
				return a.length;
			else
				return 0;
		}
		int[] f = new int[a.length];

		if(a[0] >0 && a[0]<10)
			f[0] = 1;
		if(a[1] >0 && a[1]<10)
			f[1] += f[0];
		
		if(addNeib(a[0],a[1])>9 && addNeib(a[0],a[1])<27)
			f[1] += 1;
		
		for(int i=2;i<a.length;i++){
			if(f[i-2]==0 &&f[i-1]==0 )
				f[i]=0;
			else{ 
				if(f[i-1] > 0 && a[i] >0 && a[i]<10)
					f[i] += f[i-1];
				if(f[i-2] > 0 && addNeib(a[i-1], a[i])>9 && addNeib(a[i-1], a[i])<27 )
					f[i] += f[i-2];
			}
		}
			
		printArr(f);
		return f[a.length-1];
	}
	
	public void printArr(int[] f){
		for(int a: f) System.out.println(a);
	}
	
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings("111"));
	}

}
