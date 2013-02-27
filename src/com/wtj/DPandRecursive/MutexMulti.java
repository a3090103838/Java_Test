package com.wtj.DPandRecursive;

import java.util.Scanner;

class Matrix{
	public int left;
	public int right;
	}

public class MutexMulti {
	
	public static int dpForOnestep(int[][] a,Matrix[]ma,int i,int j){
		if(a[i][j]>-1)
			return a[i][j];
		else{
			int min = 10000;
			for(int k = i;k<j;k++){
				int tmp = dpForOnestep(a,ma, i, k)+dpForOnestep(a,ma, k+1, j)+ma[i].left*ma[k].right*ma[j].right;
				if(tmp<min)
					min = tmp;
			}
			return min;
		}
			
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		Matrix[] ma = new Matrix[n];
		for(int i = 0;i<n;i++){
			ma[i] = new Matrix();
			ma[i].left = in.nextInt();
			ma[i].right = in.nextInt();
		}
		
		int[][] dp = new int[n][n];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				if(i==j)
					dp[i][j] = 0;
				else
					dp[i][j] = -1;
			}
		}
		
		System.out.println(dpForOnestep(dp, ma, 0, n-1));
		
	}

}
