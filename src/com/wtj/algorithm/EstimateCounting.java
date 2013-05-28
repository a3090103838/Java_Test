package com.wtj.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class EstimateCounting {
	
	public static final  List<Integer> nums = new ArrayList<Integer>();
	public static final  Set<Integer> numsSet = new HashSet<Integer>();
	
	static{
		Random ran = new Random();
		for(int i = 0;i<30;i++){
			int num = ran.nextInt(100);
			nums.add(num);
			numsSet.add(num);
		}
		for(int num:nums){
				System.out.println(" "+num);
			}
		
	}
	
	public static int JSHash(String str){  
	      long hash = 1315423911;  
	      for(int i = 0; i < str.length(); i++)  
	      {  
	         hash ^= ((hash << 5) + str.charAt(i) + (hash >> 2));  
	      }  
	      return (int) (Math.abs(hash)%67);  
	} 
	
	public static int RSHash(String str){  
	      int b     = 378551;  
	      int a     = 63689;  
	      long hash = 0;  
	      for(int i = 0; i < str.length(); i++)  
	      {  
	         hash = hash * a + str.charAt(i);  
	         a    = a * b;  
	      }  
	      return (int) (Math.abs(hash)%67);   
	} 
	
	public static int countRightZero(int num){
		int ans = 0;
		if(num==0)
			return 0;
		while((num&1)!=1){
			ans++;
			num=num>>1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int max = 0;
		for(int num:nums){
			int countOfThis = countRightZero(RSHash(String.valueOf(num)));
			if (countOfThis>max){
				max = countOfThis;
				System.out.println("max:"+max);
			}
		}
		
		System.out.println("the ans is:" +Math.pow(2, max));
		System.out.println("the true ans is:" +numsSet.size());
		
	}

}
