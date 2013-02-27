package com.wtj.patpractice;

import java.util.Scanner;

public class ShortestDistance {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = 0;
		int[] num = new int[n];
		for(int i = 0;i<n-1;i++){
			num[i]=in.nextInt();
			sum = sum+num[i];
		}
		num[n-1]=in.nextInt();
		sum=sum+num[n-1];
		
		int numOfQuery = in.nextInt();
		for(int i =0;i<numOfQuery;i++){
			int start = in.nextInt();
			int end = in.nextInt();
			if(start>end){
				int tmp = start;
				start = end;
				end = tmp;
			}
			
			int ans = 0;
			for(int j=start-1;j<=(end-2);j++){
				ans += num[j]; 
			}
			if(ans>sum-ans){
				ans = sum-ans;
			}
			System.out.println(ans);
		}

	}

}
