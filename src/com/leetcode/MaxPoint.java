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
				if(x==0&&y!=0){
					key="0-1";
				}
				else if(y==0&&x!=0){
					key="1-0";
				}
				else if(x==0 && y==0){
					selfCount++;
				}else{
					int left = x/maxCommon(abs(x), abs(y));
					int right = y/maxCommon(abs(x), abs(y));
					key = String.valueOf((double)left/right);
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
		Point[] points3 = 
		{new Point(40,-23),
			new Point(9,138),
			new Point(429,115),
			new Point(50,-17),
			new Point(-3,80),
			new Point(-10,33),
			new Point(5,-21),
			new Point(-3,80),
			new Point(-6,-65),
			new Point(-18,26),
			new Point(-6,-65),
			new Point(5,72),
			new Point(0,77),
			new Point(-9,86),
			new Point(10,-2),
			new Point(-8,85),
			new Point(21,130),
			new Point(18,-6),
			new Point(-18,26),
			new Point(-1,-15),
			new Point(10,-2),
			new Point(8,69),
			new Point(-4,63),
			new Point(0,3),
			new Point(-4,40),
			new Point(-7,84),
			new Point(-8,7),
			new Point(30,154),
			new Point(16,-5),
			new Point(6,90),
			new Point(18,-6),
			new Point(5,77),
			new Point(-4,77),
			new Point(7,-13),
			new Point(-1,-45),
			new Point(16,-5),
			new Point(-9,86),
			new Point(-16,11),
			new Point(-7,84),
			new Point(1,76),
			new Point(3,77),
			new Point(10,67),
			new Point(1,-37),
			new Point(-10,-81),
			new Point(4,-11),
			new Point(-20,13),
			new Point(-10,77),
			new Point(6,-17),
			new Point(-27,2),
			new Point(-10,-81),
			new Point(10,-1),
			new Point(-9,1),
			new Point(-8,43),
			new Point(2,2),
			new Point(2,-21),
			new Point(3,82),
			new Point(8,-1),
			new Point(10,-1),
			new Point(-9,1),
			new Point(-12,42),
			new Point(16,-5),
			new Point(-5,-61),
			new Point(20,-7),
			new Point(9,-35),
			new Point(10,6),
			new Point(12,106),
			new Point(5,-21),
			new Point(-5,82),
			new Point(6,71),
			new Point(-15,34),
			new Point(-10,87),
			new Point(-14,-12),
			new Point(12,106),
			new Point(-5,82),
			new Point(-46,-45),
			new Point(-4,63),
			new Point(16,-5),
			new Point(4,1),
			new Point(-3,-53),
			new Point(0,-17),
			new Point(9,98),
			new Point(-18,26),
			new Point(-9,86),
			new Point(2,77),
			new Point(-2,-49),
			new Point(1,76),
			new Point(-3,-38),
			new Point(-8,7),
			new Point(-17,-37),
			new Point(5,72),
			new Point(10,-37),
			new Point(-4,-57),
			new Point(-3,-53),
			new Point(3,74),
			new Point(-3,-11),
			new Point(-8,7),
			new Point(1,88),
			new Point(-12,42),
			new Point(1,-37),
			new Point(2,77),
			new Point(-6,77),
			new Point(5,72),
			new Point(-4,-57),
			new Point(-18,-33),
			new Point(-12,42),
			new Point(-9,86),
			new Point(2,77),
			new Point(-8,77),
			new Point(-3,77),
			new Point(9,-42),
			new Point(16,41),
			new Point(-29,-37),
			new Point(0,-41),
			new Point(-21,18),
			new Point(-27,-34),
			new Point(0,77),
			new Point(3,74),
			new Point(-7,-69),
			new Point(-21,18),
			new Point(27,146),
			new Point(-20,13),
			new Point(21,130),
			new Point(-6,-65),
			new Point(14,-4),
			new Point(0,3),
			new Point(9,-5),
			new Point(6,-29),
			new Point(-2,73),
			new Point(-1,-15),
			new Point(1,76),
			new Point(-4,77),
			new Point(6,-29)};
		MaxPoint mp = new MaxPoint();
		System.out.println(mp.maxPoints(points1));
		System.out.println(mp.maxPoints(points2));
		System.out.println(mp.maxPoints(points3));
	}

}
