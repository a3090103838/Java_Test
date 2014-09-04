package com.leetcode;

import java.util.ArrayList;
import java.util.List;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
     
 }

public class MergeIntervals {
	public void helper(List<Interval> intervals, int start){
		if(start==intervals.size()-1) return;
		
		Interval cur = intervals.get(start);
		Interval next = intervals.get(start+1);
		if(next.start>cur.end)
			helper(intervals, start+1);
		else{
			intervals.remove(start+1);
			cur.end = cur.end>=next.end?cur.end:next.end;
			helper(intervals, start);
		}
	}
	
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals==null) return intervals;
    	helper(intervals, 0);
		return intervals;      
    }
	
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		System.out.println(mi.merge(intervals));
	}

}
