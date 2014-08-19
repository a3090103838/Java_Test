package com.leetcode;

public class Triange {

	public int min(int a, int b){
		return a<=b?a:b;
	}
	
	public void gao(int[][] a, int length){
		for(int i=length-1; i>=0; i--){
			for(int j=0; j<=i;j++){
				a[i][j] = min(a[i+1][j], a[i+1][j+1]) + a[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] a ={
		            {2},
		            {3,4},
		           {6,5,7},
		          {4,1,8,3}
					};
		
		Triange t = new Triange();
		t.gao(a, a.length-1);
		System.out.println(a[0][0]);

	}

}
