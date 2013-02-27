package com.wtj.patpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingInMars {

	public static void main(String[] args) {

		int n,sum;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		sum = in.nextInt();
		
		int[] a = new int[n];
		for(int i = 0;i<n;i++){
			a[i] = in.nextInt();
		}
		
		int i = 0;
		int j = 0;
		int s = 0;
		int e = 0;
		int minDist = 100;
		int current = a[0];
		Map<Integer,Integer>map = new HashMap<Integer, Integer>();
		
		for(;;){
			if(current<sum){
				if((sum-current)<minDist){
					minDist = sum-current;
					s = i;
					e = j;
				}
				j++;
				if(j>=n)
					break;
				current +=a[j]; 
			}
			else if(current>sum){
				if((current-sum)<minDist){
					minDist = current-sum;
					s = i;
					e = j;
				}
				i++;
				if(i>=n)
					break;
				if(i>j){
					j=i;
					current = a[i];
				}
				else{
					current-=a[i-1];
				}
			}
			else{
				map.put(i+1, j+1);
				j++;
				current +=a[j];
				if(j>=n)
					break;
			}
				
		}
		
		for(Map.Entry<Integer, Integer>entry:map.entrySet()){
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		
		if(map.size()==0)
			System.out.println(s+"-"+e);
	}

}
