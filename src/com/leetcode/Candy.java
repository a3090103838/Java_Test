package com.leetcode;

public class Candy {

    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
        if(ratings.length==1) return 1;
        
        int length = ratings.length;
        int[] low = new int[ratings.length];
        int[] res = new int[ratings.length];
        low[0] = ratings[0]<ratings[1]?1:0;
        low[length-1] = ratings[length-1]<ratings[length-2]?1:0;
        for(int i=1;i<=(length-2);i++){
            if(ratings[i]<ratings[i-1] && ratings[i]<ratings[i+1] )
                low[i] = 1;
        }
        
        boolean start = false;
        int base = 0;
        for(int i=0;i<length;i++){
            if(start==false&&low[i]==0) continue;
            if(low[i]==1){
                start = true;
                res[i] = 1;
                base = 1;
            }
            else{
                if(ratings[i]>ratings[i-1])
                    res[i] = ++base;
                if(ratings[i]==ratings[i-1])
                    res[i] = --base;
            }
        }
        print_arr(res);
        start = false;
        for(int i=length-1;i>=0;i--){
            if(start==false&&low[i]==0) continue;
            if(low[i]==1){
                start = true;
                res[i] = 1;
                base = 1;
            }
            else{
                if(ratings[i]>ratings[i+1])
                    res[i] = Math.max(res[i],++base);
                if(ratings[i]==ratings[i+1])
                    res[i] = Math.min(res[i],--base);
            }
        }
        
        print_arr(res);
        return sum(res);
    }
    
    private int sum(int[] res) {
        int ans = 0;
        for(int num: res) ans +=num;
        return ans;
    }
    
    public void print_arr(int[] a){
        for(int n: a){
            System.out.print(n+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        System.out.println(c.candy(new int[] {1,2,4,4,3}));
    }

}
