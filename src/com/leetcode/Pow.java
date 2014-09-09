package com.leetcode;

public class Pow {
	 public double pow(double x, int n) {
	    	if(n<0) return 1.0/pow(x,-n);
		    return power(x, n);
	    }
	
	
    public double power(double x, int n) {
    	if(n==0) return 1;
    	
    	double rec = power(x, n/2);
        if(n%2==0){
        	return rec * rec;
        }else{
        	return rec * rec * x;
        }
    }
    
	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.pow(1.0, -2147483648));
	}
}
