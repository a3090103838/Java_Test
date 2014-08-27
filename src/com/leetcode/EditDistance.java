package com.leetcode;

public class EditDistance {

	public int min(int a, int b){
		return a<b?a:b;
	}
	
	public int DPHelper(char[] a, char[] b){
		int[][] f = new int[a.length][b.length];
		
		for(int i=0; i<a.length;i++) f[i][0] = i;
		for(int i=0; i<b.length;i++) f[0][i] = i;
		
		for(int i=1;i<a.length;i++){
			for(int j=1;j<b.length;j++){
				if(a[i]==b[j])
					f[i][j] = f[i-1][j-1];
				else
					f[i][j] = min(f[i-1][j],f[i][j-1],f[i-1][j-1])+1;
			}
		}
		return f[a.length-1][b.length-1];		
	}
	
	public int recurseHelper(char[] a, char[] b, int aIndex, int bIndex){
		if(aIndex==a.length) return b.length-bIndex;
		if(bIndex==b.length) return a.length-aIndex;
		
		if(a[aIndex]==b[bIndex])
			return recurseHelper(a, b, aIndex+1, bIndex+1);
		else
			return min(recurseHelper(a, b, aIndex+1, bIndex+1), recurseHelper(a, b, aIndex+1, bIndex), recurseHelper(a, b, aIndex, bIndex+1)) +1;
	}
	
    private int min(int a, int b, int c) {
		if(a<b)
			return a<c?a:c;
		else
			return b<c?b:c;
	}

	public int minDistance(String word1, String word2) {
        return DPHelper((" "+ word1).toCharArray(),	 (" "+word2).toCharArray());
    }
	
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance("a", "b"));
	}

}
