package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {

    private void dfs(char[][] pad, int level, List<String[]> res){
        if(level>=pad.length){
            res.add(toRes(pad));
            return;
        }
        else{
            for(int curIndex=0;curIndex<pad.length;curIndex++){
                if(isNotConflict(pad, level, curIndex)){
                    pad[level][curIndex] = 'Q';
                    dfs(pad, level+1, res);
                    pad[level][curIndex] = '.';
                }
            }
        }
    }
    
    private boolean isNotConflict(char[][] pad, int level, int curIndex) {
        for(int i=level-1;i>=0;i--){
            if(pad[i][curIndex]=='Q')
                return false;
        }
        
        int i = level-1;
        int j = curIndex-1;
        while(i>=0&&j>=0){
            if(pad[i][j]=='Q')
                return false;
            i--;
            j--;
        }
        
        i = level-1;
        j = curIndex+1;
        while(i>=0&&j<pad.length){
            if(pad[i][j]=='Q')
                return false;
            i--;
            j++;
        }
        
        return true;
    }

    private String[] toRes(char[][] pad) {
        String[] res = new String[pad.length];
        for(int i=0;i<pad.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<pad.length;j++){
                sb.append(""+pad[i][j]);
            }
            res[i] = sb.toString();
        }
        return res;
    }

    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        char[][] pad = new char[n][n];
        fillTwoDimArray(pad, '.');
        
        dfs(pad, 0, res);
        return res;
        
    }
    
    private void fillTwoDimArray(char[][] pad, char c) {
        int n = pad.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pad[i][j] = c;
            }
        }       
    }
    
    public int totalNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        char[][] pad = new char[n][n];
        fillTwoDimArray(pad, '.');
        
        dfs(pad, 0, res);
        return res.size();   
    }

    public static void main(String[] args) {
        Nqueens nq = new Nqueens();
        print_res(nq.solveNQueens(4));
    }

    private static void print_res(List<String[]> solveNQueens) {
        for (String[] strings : solveNQueens) {
            for (String string : strings) {
                System.out.println(string+"");
            }
            System.out.println();
        }
        
    }

}
