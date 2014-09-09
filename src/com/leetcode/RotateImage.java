package com.leetcode;

public class RotateImage {

    public void rotate(int[][] matrix) {
    	int n = matrix.length;
    	
        for(int i=0;i<n;i++){
        	for(int j=0;j<=(n-1-i);j++){
        		swap(matrix, i,j,n-1-j,n-1-i);
        	}
        }
        
        for(int i=0;i<n/2;i++){
        	for(int j=0;j<n;j++){
        		swap(matrix, i,j,n-1-i,j);
        	}
        }
    }
	
	private void swap(int[][] matrix, int i, int j, int k, int l) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[k][l];
		matrix[k][l]= tmp;
	}

	public static void main(String[] args) {
		RotateImage ri = new RotateImage();
		int[][] a = new int[][]{new int[] {1,2}, new int[] {3,4}};
		ri.rotate(a);
		System.out.println(a);

	}

}
