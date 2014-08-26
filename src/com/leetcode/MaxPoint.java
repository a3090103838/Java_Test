package com.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Point {
    int x; 
    int y; 
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPoint {
	
	public int maxCommon(int a, int b){
		if(a*b == 0) return 0;
		
		int large = a>=b?a:b;
		int small = a>=b?b:a;
		
		while(large%small!=0){
			int tmp = small;
			small = large%small;
			large = tmp;
		}
		
		return small;
	}
	
	public int abs(int a){
		return a<0?-a:a;
	}
	
	public String getKey(int x, int y){
		String key;
		if(x==0&&y!=0){
			key="0-1";
		}
		else if(y==0&&x!=0){
			key="1-0";
		}else{
			int left = x/maxCommon(abs(x), abs(y));
			int right = y/maxCommon(abs(x), abs(y));
			key = String.valueOf((double)left/right);
		}
		return key;
	}
	
	public  int maxPoints(Point[] points){
		if(points == null) return 0;
		if(points.length ==0 || points.length ==1 ) return points.length;
		
		int max = 0;
		for(int i = 0; i< points.length-1; i++){
			Map<String, Integer> map = new HashMap<String, Integer>();
			int selfCount = 1;
			for(int j = i+1; j<points.length; j++){
				int x = points[i].x -  points[j].x;
				int y = points[i].y -  points[j].y;
				String key = null;
				 if(x==0 && y==0){
					selfCount++;
				}else{
					key = getKey(x, y);
				}
				
				if(key!=null){
					if(map.containsKey(key)){
						map.put(key, map.get(key)+1);
					}
					else{
						map.put(key, 1);
					}
				}
			}
			
			int currentMax = 0;
			int otherMax = 0;
			if(map.values().size() != 0)
				otherMax = Collections.max(map.values()) + selfCount;
			currentMax = otherMax > selfCount?otherMax:selfCount;
			
			max = currentMax>max?currentMax:max;
		}
		
		return max;	
	}
	
	public void printMap(Map<String,Integer> map){
		for(String key: map.keySet()){
			System.out.println(key+" "+map.get(key));
		}
	}
	
	public static void main(String[] args) {
		Point[] points1 = {new Point(1,1), new Point(2,2), new Point(3,3), new Point(5,1),};
		Point[] points2 = {new Point(1,1), new Point(0,0),};
		
		MaxPoint mp = new MaxPoint();
		System.out.println(mp.maxPoints(points1));
		System.out.println(mp.maxPoints(points2));
	}

}
