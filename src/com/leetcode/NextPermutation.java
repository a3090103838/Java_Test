package com.leetcode;

public class NextPermutation {

    public void nextPermutation(int[] num) {
        if(num==null || num.length==1) return;
        int n = num.length;
        int cut = n-2;
        
        while(cut>=0 && num[cut]>=num[cut+1]) cut--;
        if(cut<0){ 
        	insertionSort(num, 0);
        	return;
        	}
        
        int replace = cut+1;
        while(replace<n && num[replace]>=num[cut]) replace++;
        swap(num, replace-1, cut);
        
        insertionSort(num, cut+1);
    }
    
    
	
	private void insertionSort(int[] num, int m) {
		if(m>=num.length-1) return;
		for(int i = m+1;i<num.length;i++){
			int cur = i;
			while(cur>=(m+1) && num[cur]<num[cur-1]){
				swap(num, cur, cur-1);
				cur--;
			}
		}
		
	}



	private void swap(int[] num, int i, int cut) {
		int tmp = num[i];
		num[i] = num[cut];
		num[cut] = tmp;
	}
	
	



	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] n = new int[] {1,3,2};
		np.nextPermutation(n);
		for(int num: n)
			System.out.println(num);

	}

}
