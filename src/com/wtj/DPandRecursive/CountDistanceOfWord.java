package com.wtj.DPandRecursive;

public class CountDistanceOfWord {

	public static int countDis(String s1,String s2)
	{
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		return countDisOfChar(a, b,0,0);	
	}
	
	private static int countDisOfChar(char[] a,char[] b,int i,int j)
	{
		if(a.length==i)return b.length-j;
		if(b.length==i)return a.length-i;
		
		if(a[i]==b[j]) 
			return countDisOfChar(a, b, i+1,j+1);
		else
			return min(countDisOfChar(a, b, i+1, j),countDisOfChar(a, b, i, j+1),countDisOfChar(a, b, i+1, j+1))+1;
	}
	
	public static int min(int a,int b,int c)
	{
		if(a<b){
			if(a<c)
				return a;
			else
				return c;
		}
		else{
			if(b<c)
				return b;
			else
				return c;
		}
			
	}

	public static void main(String[] args) {
		System.out.print(countDis("abc", "dqwerabc923"));
	}

}
